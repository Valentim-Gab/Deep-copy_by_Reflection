package org.example.services;

import org.example.decorators.NoCopy;
import org.example.interfaces.Copy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Collection;

public class DeepCopy implements Copy {
    @Override
    public <T> T copyObject(T object) {
        if (object == null || object.getClass().getAnnotation(NoCopy.class) != null) {
            return null;
        }

        Class<?> clazz = object.getClass();
        T objectClone;

        try {
            objectClone = (T) clazz.newInstance();

            for (Field field: object.getClass().getDeclaredFields()) {
                if (field.getAnnotation(NoCopy.class) == null) {
                    Field fieldClone = objectClone.getClass().getDeclaredField(field.getName());
                    Object atrValue = getValueField(field, object);
                    fieldClone.set(objectClone, atrValue);
                }
            }
        } catch (InstantiationException e) {
            System.out.println("Erro ao instanciar a classe");

            return null;
        } catch (IllegalAccessException e) {
            System.out.println("Acesso ilegal a classe ou alguma propriedade");

            return null;
        } catch (NoSuchFieldException e) {
            System.out.println("Uma propriedade não foi encontrada");

            return null;
        } catch (InvocationTargetException e) {
            System.out.println("Ocorreu um erro ao fazer uma chamada");

            return null;
        } catch (NoSuchMethodException e) {
            System.out.println("Ocorreu um erro com método da classe");

            return null;
        }

        return objectClone;
    }

    public Object getValueField(Field field, Object object) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        field.setAccessible(true);
        Object atrValue = field.get(object);

        if (isNormalType(field)) {
            return atrValue;
        } else if (isList(field)) {
            return atrValue.getClass().getDeclaredConstructor(Collection.class).newInstance(atrValue);
        } else {
            return copyObject(atrValue);
        }
    }

    public boolean isList(Field field) {
        return Collection.class.isAssignableFrom(field.getType());
    }

    public boolean isNormalType(Field field) {
        return (field.getType().isPrimitive() || field.getType().equals(String.class)
                || field.getType().equals(Date.class) || field.getType().equals(Integer.class)
                || field.getType().equals(Boolean.class));
    }
}
