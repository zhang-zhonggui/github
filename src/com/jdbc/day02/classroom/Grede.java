package com.jdbc.day02.classroom;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public class Grede {
    private  int id;
    private  String grede;

    public Grede() {
    }

    public Grede(int id, String grede) {
        this.id = id;
        this.grede = grede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrede() {
        return grede;
    }

    public void setGrede(String grede) {
        this.grede = grede;
    }

    @Override
    public String toString() {
        return "Grede{" +
                "id=" + id +
                ", grede='" + grede + '\'' +
                '}';
    }
}
