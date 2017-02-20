package com.liuhy.constructorinject;

/**
 * Created by liuhy on 2017/2/18.
 */
public class User
{
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public User(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
}
