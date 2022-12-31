package Repository;

import Annotation.Column;
import DbConnection.IDbConnection;
import Query.Query.Query;
import Query.Query.SelectQuery;
import Query.Value.FieldValue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Repository<T, ID> {
    private static IDbConnection conn;
    private Class<T> classReflection;
    private Class<ID> idClassReflection;

    public Repository(Class<T> classReflection, Class<ID> idClassReflection) {
        this.classReflection = classReflection;
        this.idClassReflection = idClassReflection;
    }
    public static void setConnectionAdapter(IDbConnection conn) {
        Repository.conn = conn;
    }


    Collection<T> findAll() throws Exception {
        Field[] fields = classReflection.getFields();

        SelectQuery create = new SelectQuery();
        FieldValue tableName = new FieldValue(classReflection.getSimpleName());
        String sql = create.select().from(tableName).build();

        List<T> results = new ArrayList<>();
        ResultSet resultSet = getResultSet(sql);
        while (resultSet.next()) {
            T t = (T) classReflection.getConstructor().newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                Column columnAnnotation = field.getAnnotation(Column.class);
                String columnName = columnAnnotation.value() == null ||
                        columnAnnotation.value().length() == 0 ?
                        field.getName() : columnAnnotation.value();

                //setFields(field, resultSet, t, columnName);
            }
        }
        return null;
    }

    protected ResultSet getResultSet(String sql) throws SQLException {
        Statement statement = Repository.conn.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    private void setFields(Field field, ResultSet resultSet, T t, String columnName) throws Exception{
        if (int.class.equals(field.getType()) || Integer.class.equals(field.getType())) {
            field.set(t, resultSet.getInt(columnName));
        } else if (long.class.equals(field.getType()) || Long.class.equals(field.getType())) {
            field.set(t, resultSet.getLong(columnName));
        } else if (String.class.equals(field.getType())) {
            field.set(t, resultSet.getString(columnName));
        } else if (boolean.class.equals(field.getType()) || Boolean.class.equals(field.getType())) {
            field.set(t, resultSet.getBoolean(columnName));
        } else if (double.class.equals(field.getType()) || Double.class.equals(field.getType())) {
            field.set(t, resultSet.getDouble(columnName));
        } else if(float.class.equals(field.getType()) || Float.class.equals(field.getType())){
            field.set(t, resultSet.getFloat(columnName));
        } else {
            throw new IllegalStateException("Unexpected value: " + field.getType());
        }
    }
}
