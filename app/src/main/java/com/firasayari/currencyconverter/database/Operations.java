package com.firasayari.currencyconverter.database;

public class Operations {
    public static final String TABLE_NAME = "Operations";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_OP = "op";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String op;
    private String timestamp;


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_OP + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public Operations() {
    }

    public Operations(int id, String op, String timestamp) {
        this.id = id;
        this.op = op;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
