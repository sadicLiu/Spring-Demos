package com.liuhy.setterinject;

/**
 * Created by liuhy on 2017/2/18.
 */
public class Person
{
    private Integer id;
    private String name;
    private Integer age;

    private Address homeAddress;
    private Address companyAddress;

    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", homeAddress=" + homeAddress.getAddr() + " : " + homeAddress.getDoor() +
                ", companyAddress=" + companyAddress +
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

    public Address getHomeAddress()
    {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress)
    {
        this.homeAddress = homeAddress;
    }

    public Address getCompanyAddress()
    {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress)
    {
        this.companyAddress = companyAddress;
    }
}
