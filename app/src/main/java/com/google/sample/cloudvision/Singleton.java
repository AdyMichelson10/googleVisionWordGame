package com.google.sample.cloudvision;

import java.util.Hashtable;

public class Singleton {
    public Hashtable<String,CategoryLogic> m_Categories;
    private static Singleton instance = null;
    public static Singleton Instance()
    {
        if(instance == null)
            instance = new Singleton();
        return instance;
    }

    private Singleton()
    {
        m_Categories = new Hashtable<String,CategoryLogic>();
        WordLogic word1 = new WordLogic("Table",false,"Shulhan","somePath1");
        WordLogic word2 = new WordLogic("chair",false,"kiseh","somePath2");
        CategoryLogic cat = new CategoryLogic("Room");
        cat.AddWord(word1);
        cat.AddWord(word2);
        m_Categories.put("Room", cat);
    }
}
