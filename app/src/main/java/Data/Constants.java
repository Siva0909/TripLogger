package Data;

/**
 * Created by sivan on 24/05/2018.
 */

public class Constants {

    public static final String DATABASE_NAME="tripdb";
    public static final int DATABASE_VERSION=1;
    // wishes is the table name
    public static final String TABLE_TRIPS="trips";
    public static final String TABLE_SETTINGS="settings";

    //column common for both table
    public static final String KEY_ID="_id";
    public static final String RECORD_DATE="recorddate";
    public static final String COMMENT="comment";


    //below are the column or field name in the table wishes that is created above
    //we have to create a model or class which is created in the model package

    //Column for table_trips
    public static final String TITLE="title";
    public static final String DATE="date";
    public static final String TRIP_TYPE="trip_type";
    public static final String DESTINATION="destination";
    public static final String DURATION="duration";


    //Column for Table_settings
    public static final String NAME="name";
    public static final String EMAIL="email";
    public static final String GENDER="gender";







}
