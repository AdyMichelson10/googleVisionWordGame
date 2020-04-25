package com.google.sample.cloudvision;

public class WordLogic {


    private String m_Word;
    private boolean m_IsDone;
    private boolean m_FirstTime;
    private String m_Translation;
    private String m_PhotoPath;

    public WordLogic(String i_Word, boolean i_IsDone, String i_Translation, String i_PhotoPath)
    {
        m_Word = i_Word;
        m_IsDone = i_IsDone;
        m_FirstTime = true;
        m_Translation = i_Translation;
        m_PhotoPath = i_PhotoPath;
    }
    protected boolean equals(WordLogic i_WordLogic)//ToTest
    {
        return this.m_Word == i_WordLogic.m_Word;
    }

    public String GetWord(){return m_Word;}
    public String get_Word() {
        return m_Word;
    }

    public boolean get_IsDone() {
        return m_IsDone;
    }

    public void set_IsDone(boolean m_IsDone) {
        this.m_IsDone = m_IsDone;
    }

    public boolean get_FirstTime() {
        return m_FirstTime;
    }

    public void set_FirstTime(boolean m_FirstTime) {
        this.m_FirstTime = m_FirstTime;
    }

    public String get_Translation() {
        return m_Translation;
    }

    public void set_Translation(String m_Translation) {
        this.m_Translation = m_Translation;
    }

    public String get_PhotoPath() {
        return m_PhotoPath;
    }

    public void set_PhotoPath(String m_PhotoPath) {
        this.m_PhotoPath = m_PhotoPath;
    }
}
