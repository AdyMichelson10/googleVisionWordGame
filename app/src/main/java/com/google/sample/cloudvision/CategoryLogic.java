package com.google.sample.cloudvision;

import java.util.Hashtable;
public class CategoryLogic {
    private String m_CategoryName;
    public Hashtable<String,WordLogic> m_WordTable;

    public CategoryLogic(String i_CategoryName)
    {
        m_CategoryName = i_CategoryName;
        m_WordTable = new Hashtable<String,WordLogic>();
    }

    public void AddWord(WordLogic i_Word)
    {
        if(!m_WordTable.containsKey(i_Word.GetWord()))
        {
            m_WordTable.put(i_Word.GetWord(), i_Word);
            //notify that the word was added successfully?
        }
    }
}
