package com.liuhy.collectioninject;

import java.util.*;

/**
 * Created by liuhy on 2017/2/18.
 */
public class CollectionData
{
    private String[] fruits;
    private List<String> vegetables;
    private Set<String> backend;
    private Map<String, String> frameworks;
    private Properties resume;

    @Override
    public String toString()
    {
        return "CollectionData{" +
                "\nfruits=" + Arrays.toString(fruits) +
                ", \nvegetables=" + vegetables +
                ", \nbackend=" + backend +
                ", \nframeworks=" + frameworks +
                ", \nresume=" + resume +
                '}';
    }

    public String[] getFruits()
    {
        return fruits;
    }

    public void setFruits(String[] fruits)
    {
        this.fruits = fruits;
    }

    public List<String> getVegetables()
    {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables)
    {
        this.vegetables = vegetables;
    }

    public Set<String> getBackend()
    {
        return backend;
    }

    public void setBackend(Set<String> backend)
    {
        this.backend = backend;
    }

    public Map<String, String> getFrameworks()
    {
        return frameworks;
    }

    public void setFrameworks(Map<String, String> frameworks)
    {
        this.frameworks = frameworks;
    }

    public Properties getResume()
    {
        return resume;
    }

    public void setResume(Properties resume)
    {
        this.resume = resume;
    }
}
