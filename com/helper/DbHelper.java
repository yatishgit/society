
package com.helper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.bean.Album;
import com.bean.AlbumImages;
import com.bean.Booking;
import com.bean.Category;
import com.bean.Committee;
import com.bean.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by TheLucifer on 3/17/2016.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Societtee.db";
    public static final int VERSION = 1;
    private HashMap hp;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USER_TABLE="CREATE TABLE IF NOT EXISTS user(" +
                "userId TEXT PRIMARY KEY," +
                "userName TEXT,"+
                "userEmailId TEXT,"+
                "userContact TEXT,"+
                "userAddress TEXT,"+
                "userImage TEXT,"+
                "name TEXT,"+
                "userFlatNo TEXT,"+
                "userType TEXT,"+
                "expiryDate TEXT,"+
                "approvalStatus TEXT,"+
                "pollingAllowed TEXT,"+
                "societyId TEXT,"+
                "buildingId TEXT,"+
                ")";
        db.execSQL(CREATE_USER_TABLE);

        String CREATE_FLAT_TABLE="CREATE TABLE IF NOT EXIST flat(" +
                "flatId TEXT PRIMARY KEY," +
                "buildingId TEXT,"+
                "societyId TEXT,"+
                "flatNo TEXT,"+
                "flatArea TEXT,"+
                "flatType TEXT,"+
                "name TEXT,"+
                "memberCount TEXT,"+
                "owner TEXT,"+
                "pollingAllowed TEXT,"+
                "userId TEXT,"+
                "ownerId TEXT,"+
                ")";
        db.execSQL(CREATE_FLAT_TABLE);

        String CREATE_HELPDESK_PERSONAL_TABLE="CREATE TABLE IF NOT EXIST helpdesk_personal(" +
                "issueId TEXT PRIMARY KEY," +
                "buildingId TEXT,"+
                "societyId TEXT,"+
                "category TEXT,"+
                "userId TEXT,"+
                "description TEXT,"+
                "issueDate TEXT,"+
                "resolvedStatus TEXT,"+
                "resolvedDate TEXT,"+
                "status TEXT,"+
                "image TEXT,"+
                "issueBy TEXT,"+
                "type TEXT,"+
                ")";
        db.execSQL(CREATE_HELPDESK_PERSONAL_TABLE);

        String CREATE_HELPDESK_SOCIETY_TABLE="CREATE TABLE IF NOT EXIST helpdesk_society(" +
                "issueId TEXT PRIMARY KEY," +
                "buildingId TEXT,"+
                "societyId TEXT,"+
                "category TEXT,"+
                "userId TEXT,"+
                "description TEXT,"+
                "issueDate TEXT,"+
                "resolvedStatus TEXT,"+
                "resolvedDate TEXT,"+
                "status TEXT,"+
                "image TEXT,"+
                "issueBy TEXT,"+
                "type TEXT,"+
                ")";
        db.execSQL(CREATE_HELPDESK_SOCIETY_TABLE);

        String CREATE_BOOKING_TABLE="CREATE TABLE IF NOT EXIST booking(" +
                "bookingId TEXT PRIMARY KEY," +
                "bookingDate TEXT,"+
                "userId TEXT,"+
                "facilityId TEXT,"+
                "fromDate TEXT,"+
                "toDate TEXT,"+
                "buildingId TEXT,"+
                "flatNo TEXT,"+
                "amountDeposited TEXT,"+
                "depositedDate TEXT,"+
                "rDescription TEXT,"+
                "rPaymentmode TEXT,"+
                "rChequeNo TEXT,"+
                "amountRefunded TEXT,"+
                "refundDate TEXT,"+
                "description TEXT,"+
                "paymentMode TEXT,"+
                "chequeNo TEXT,"+
                "status TEXT,"+
                "societyId TEXT,"+
                ")";
        db.execSQL(CREATE_BOOKING_TABLE);


        String CREATE_ALBUM_TABLE="CREATE TABLE IF NOT EXIST album(" +
                "societyId TEXT ," +
                "AlbumId TEXT PRIMARY KEY,"+
                "albumTitle TEXT,"+
                "addedDate TEXT,"+
                "description TEXT,"+
                "image TEXT,"+
                ")";
        db.execSQL(CREATE_ALBUM_TABLE);

        String CREATE_ALBUM_IMAGE_TABLE="CREATE TABLE IF NOT EXIST albumImage(" +
                "imageId TEXT PRIMARY KEY," +
                "AlbumId TEXT,"+
                "societyId TEXT,"+
                "image TEXT,"+
                ")";
        db.execSQL(CREATE_ALBUM_IMAGE_TABLE);


        String CREATE_COMMITTEE_TABLE="CREATE TABLE IF NOT EXIST committee(" +
                "committeeId TEXT PRIMARY KEY," +
                "name TEXT,"+
                "designation TEXT,"+
                "description TEXT,"+
                "showContact TEXT ," +
                "contactNo TEXT,"+
                "societyId TEXT,"+
                "buildingId TEXT,"+
                "flatNo TEXT ," +
                ")";
        db.execSQL(CREATE_COMMITTEE_TABLE);


        String CREATE_CONVERSATION_TABLE="CREATE TABLE IF NOT EXIST conversation(" +
                "conversationId TEXT PRIMARY KEY," +
                "societyId TEXT,"+
                "userId TEXT,"+
                "createDate TEXT,"+
                "date TEXT ," +
                "type TEXT,"+
                "imageId TEXT,"+
                "description TEXT,"+
                "conversationTitle TEXT ," +
                ")";
        db.execSQL(CREATE_CONVERSATION_TABLE);


        String CREATE_CONVERSATION_IMAGES_TABLE="CREATE TABLE IF NOT EXIST conversationImages(" +
                "imageId TEXT PRIMARY KEY," +
                "conversationId TEXT,"+
                "societyId TEXT,"+
                "image TEXT ," +
                ")";
        db.execSQL(CREATE_CONVERSATION_IMAGES_TABLE);


        String CREATE_FACILITY_TABLE="CREATE TABLE IF NOT EXIST facility(" +
                "facilityId TEXT PRIMARY KEY," +
                "societyId TEXT,"+
                "facilityName TEXT,"+
                "description TEXT,"+
                "image TEXT ," +
                "deposit TEXT,"+
                "availableFlag TEXT,"+
                ")";
        db.execSQL(CREATE_FACILITY_TABLE);


        String CREATE_NOTICE_TABLE="CREATE TABLE IF NOT EXIST notice(" +
                "noticeId TEXT PRIMARY KEY," +
                "societyId TEXT,"+
                "managerId TEXT,"+
                "description TEXT,"+
                "title TEXT ," +
                ")";
        db.execSQL(CREATE_NOTICE_TABLE);


        String CREATE_PARKING_TABLE="CREATE TABLE IF NOT EXIST parking(" +
                "parkingId TEXT PRIMARY KEY," +
                "societyId TEXT,"+
                "buildingId TEXT,"+
                "flatNo TEXT,"+
                "vehicleNo TEXT ," +
                "vehicleType TEXT,"+
                "parkingSlot TEXT,"+
                ")";
        db.execSQL(CREATE_PARKING_TABLE);


        String CREATE_PAYMENT_TABLE="CREATE TABLE IF NOT EXIST payment(" +
                "transactionId TEXT PRIMARY KEY," +
                "userId TEXT,"+
                "societyId TEXT,"+
                "buildingId TEXT,"+
                "flatNo TEXT,"+
                "paymentType TEXT,"+
                "description TEXT,"+
                "dueAmount TEXT,"+
                "raisedAmount TEXT,"+
                "raisedDate TEXT,"+
                "dueDate TEXT,"+
                "category TEXT,"+
                "paymentStatus TEXT,"+
                "paymentDate TEXT,"+
                "paidAmount TEXT,"+
                "paymentMode TEXT,"+
                "chequeNo TEXT,"+
                "chequeNo TEXT,"+
                "refId TEXT,"+
                "netBal TEXT,"+
                "due TEXT,"+
                ")";
        db.execSQL(CREATE_PAYMENT_TABLE);


        String CREATE_POOLING_TABLE="CREATE TABLE IF NOT EXIST pooling(" +
                "pollId TEXT PRIMARY KEY," +
                "societyId TEXT,"+
                "creator TEXT,"+
                "description TEXT,"+
                "pollDate TEXT,"+
                "expiryDate TEXT,"+
                "status TEXT,"+
                "pollFor TEXT,"+
                "contactNo TEXT,"+
                ")";
        db.execSQL(CREATE_POOLING_TABLE);


        String CREATE_POOLING_RESPONSE_TABLE="CREATE TABLE IF NOT EXIST poolingresponse(" +
                "pollId TEXT PRIMARY KEY," +
                "userId TEXT,"+
                "flatNo TEXT,"+
                "responseId TEXT,"+
                "response TEXT,"+
                "optionId TEXT,"+
                ")";
        db.execSQL(CREATE_POOLING_RESPONSE_TABLE);


        String CREATE_POOLING_OPTION_TABLE="CREATE TABLE IF NOT EXIST poolingoption(" +
                "pollId TEXT PRIMARY KEY," +
                "oprionId TEXT,"+
                "options TEXT,"+
                ")";
        db.execSQL(CREATE_POOLING_OPTION_TABLE);


        String CREATE_STAFF_TABLE="CREATE TABLE IF NOT EXIST staff(" +
                "staffId TEXT PRIMARY KEY," +
                "name TEXT,"+
                "designation TEXT,"+
                "contactNo TEXT,"+
                "idProof TEXT,"+
                "societyId TEXT,"+
                "buidingId TEXT,"+
                "flatNo TEXT,"+
                ")";
        db.execSQL(CREATE_STAFF_TABLE);


        String CREATE_VENDOR_TABLE="CREATE TABLE IF NOT EXIST vendor(" +
                "vendorId TEXT PRIMARY KEY," +
                "categoryId TEXT,"+
                "vendorName TEXT,"+
                "company TEXT,"+
                "description TEXT,"+
                "contact1 TEXT,"+
                "contact2 TEXT,"+
                "vendorAdd1 TEXT,"+
                "vendorAdd2 TEXT,"+
                "vendorAdd3 TEXT,"+
                "idProof TEXT,"+
                "societyId TEXT,"+
                ")";
        db.execSQL(CREATE_VENDOR_TABLE);

        String CREATE_VISITOR_TABLE="CREATE TABLE IF NOT EXIST visitor(" +
                "visitorId TEXT PRIMARY KEY," +
                "name TEXT,"+
                "contactNo TEXT,"+
                "societyId TEXT,"+
                "buildingId TEXT,"+
                "flatNo TEXT,"+
                "visitorType TEXT,"+
                "checkInTime TEXT,"+
                "checkOutTime TEXT,"+
                "expectedTime TEXT,"+
                "date TEXT,"+
                ")";
        db.execSQL(CREATE_VISITOR_TABLE);

        String CREATE_CATEGORY_TABLE="CREATE TABLE IF NOT EXIST category(" +
                "categoryId TEXT PRIMARY KEY," +
                "categoryName TEXT,"+
                "image TEXT,"+
                "description TEXT,"+
                ")";
        db.execSQL(CREATE_CATEGORY_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS admin_table");
        onCreate(db);
    }


    //Methods for Category ******************************************************************************************

    public void addCategory(Category category)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("categoryId",category.getCategoryId());
        values.put("categoryName",category.getCategoryName());
        values.put("image",category.getImage());
        values.put("description",category.getDescription());
        // Inserting Row
        db.insert("category", null, values);
        db.close(); // Closing database connection

    }

    public Category getCategory(String categoryId)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("category", new String[] {"categoryId","categoryName","image","description"}, "categoryId" + "=?",
                new String[] {categoryId}, null, null, null, null);
        Category category=new Category();
        if (cursor != null && cursor.moveToFirst()) {
            category = new Category(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        db.close();
        return category;
    }

    public void deleteAllCategories() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("category", null, null);
        db.close();
    }

    public void updateCategory(Category category)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put("categoryId",category.getCategoryId());
        data.put("categoryName",category.getCategoryName());
        data.put("image",category.getImage());
        data.put("description", category.getDescription());
        db.update("category", data, "categoryId=?", new String[]{category.getCategoryId()});
        db.close();
    }

    public ArrayList<Category> getAllCategories()
    {
        ArrayList<Category> categories=new ArrayList<Category>();
        String selectQuery = "SELECT  * FROM category";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Category category;
                category = new Category(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                categories.add(category);
            }while(cursor.moveToNext());
        }
        db.close();
        return categories;
    }

    public void deleteCategory(String categoryId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("category", "categoryId" + "=" + categoryId, null);
        db.close();
    }


    //Methods for AlbumImages ******************************************************************************************

    public void addAlbum(Album album)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("societyId",album.getSocietyId());
        values.put("albumId",album.getAlbumId());
        values.put("albumTitle",album.getAlbumTitle());
        values.put("addedDate",album.getAddedDate());
        values.put("description",album.getDescription());
        values.put("image",album.getImage());

        // Inserting Row
        db.insert("album", null, values);
        db.close(); // Closing database connection

    }

    public Album getAlbum(String albumId)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("album", new String[]{"societyId", "albumId", "albumTitle", "addedDate", "description", "image"}, "albumId" + "=?",
                new String[]{albumId}, null, null, null, null);
        Album album = new Album();
        if (cursor != null && cursor.moveToFirst()) {
            album = new Album(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        }
        db.close();
        return album;
    }

    public void deleteAllAlbum() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("album", null, null);
        db.close();
    }

    public void updateAlbum(Album album)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put("societyId",album.getSocietyId());
        data.put("albumId",album.getAlbumId());
        data.put("albumTitle",album.getAlbumTitle());
        data.put("addedDate", album.getAddedDate());
        data.put("description", album.getDescription());
        data.put("image", album.getImage());
        db.update("album", data, "albumId=?", new String[]{album.getAlbumId()});
        db.close();
    }

    public ArrayList<Album> getAllAlbum()
    {
        ArrayList<Album> albums=new ArrayList<Album>();
        String selectQuery = "SELECT  * FROM album";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Album album;
                album = new Album(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5));
                albums.add(album);
            }while(cursor.moveToNext());
        }
        db.close();
        return albums;
    }

    public void deleteAlbum(String albumId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("album", "albumId" + "=" + albumId, null);
        db.close();
    }


    //Methods for albumImages ******************************************************************************************

    //Methods for AlbumImages ******************************************************************************************

    public void addAlbumImage(AlbumImages albumImages)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("imageId",albumImages.getImageId());
        values.put("albumId",albumImages.getAlbumId());
        values.put("societyId",albumImages.getSocietyId());
        values.put("image",albumImages.getImage());

        // Inserting Row
        db.insert("albumImage", null, values);
        db.close(); // Closing database connection

    }

    public AlbumImages getAlbumImage(String imageId)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("albumImage", new String[]{"imageId", "albumId", "societyId", "image"}, "imageId" + "=?",
                new String[]{imageId}, null, null, null, null);
        AlbumImages albumImages = new AlbumImages();
        if (cursor != null && cursor.moveToFirst()) {
            albumImages = new AlbumImages(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        db.close();
        return albumImages;
    }

    public void deleteAllAlbumImages() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("albumImage", null, null);
        db.close();
    }

    public void updateAlbumImages(AlbumImages albumImages)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put("imageId",albumImages.getImageId());
        data.put("albumId",albumImages.getAlbumId());
        data.put("societyId",albumImages.getSocietyId());
        data.put("image", albumImages.getImage());
        db.update("albumImage", data, "imageId=?", new String[]{albumImages.getImageId()});
        db.close();
    }

    public ArrayList<AlbumImages> getAllAlbumImages()
    {
        ArrayList<AlbumImages> albumImages=new ArrayList<AlbumImages>();
        String selectQuery = "SELECT  * FROM albumImage";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                AlbumImages images;
                images = new AlbumImages(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                albumImages.add(images);
            }while(cursor.moveToNext());
        }
        db.close();
        return albumImages;
    }

    public void deleteAlbumImages(String imageId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("albumImage", "imageId" + "=" + imageId, null);
        db.close();
    }



    //Methods for Booking ******************************************************************************************

    public void addBooking(Booking booking)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("bookingId",booking.getBookingId());
        values.put("bookingDate",booking.getBookingDate());
        values.put("userId",booking.getUserId());
        values.put("facilityId", booking.getFacilityId());
        values.put("fromDate",booking.getFromDate());
        values.put("toDate",booking.getToDate());
        values.put("buildingId",booking.getBuildingId());
        values.put("flatNo",booking.getFlatNo());
        values.put("amountDeposited",booking.getAmountDeposited());
        values.put("depositedDate",booking.getDepositedDate());
        values.put("rDescription",booking.getrDescription());
        values.put("rPaymentmode",booking.getrPaymentmode());
        values.put("rChequeNo",booking.getrChequeNo());
        values.put("amountRefunded",booking.getAmountRefunded());
        values.put("refundDate",booking.getRefundDate());
        values.put("description",booking.getDescription());
        values.put("paymentMode",booking.getPaymentMode());
        values.put("chequeNo",booking.getChequeNo());
        values.put("status",booking.getStatus());
        values.put("societyId",booking.getSocietyId());

        // Inserting Row
        db.insert("booking", null, values);
        db.close(); // Closing database connection

    }

    public Booking getBooking(String bookingId)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("booking", new String[]{}, "bookingId" + "=?",
                new String[]{bookingId}, null, null, null, null);
        Booking booking = new Booking();
        if (cursor != null && cursor.moveToFirst()) {
            booking = new Booking(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getString(19));
        }
        db.close();
        return booking;
    }

    public void deleteAllBookings() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("booking", null, null);
        db.close();
    }

    public void updateBooking(Booking booking)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("bookingId",booking.getBookingId());
        values.put("bookingDate",booking.getBookingDate());
        values.put("userId",booking.getUserId());
        values.put("facilityId", booking.getFacilityId());
        values.put("fromDate",booking.getFromDate());
        values.put("toDate",booking.getToDate());
        values.put("buildingId",booking.getBuildingId());
        values.put("flatNo",booking.getFlatNo());
        values.put("amountDeposited",booking.getAmountDeposited());
        values.put("depositedDate",booking.getDepositedDate());
        values.put("rDescription",booking.getrDescription());
        values.put("rPaymentmode",booking.getrPaymentmode());
        values.put("rChequeNo",booking.getrChequeNo());
        values.put("amountRefunded",booking.getAmountRefunded());
        values.put("refundDate",booking.getRefundDate());
        values.put("description",booking.getDescription());
        values.put("paymentMode",booking.getPaymentMode());
        values.put("chequeNo",booking.getChequeNo());
        values.put("status",booking.getStatus());
        values.put("societyId",booking.getSocietyId());

        db.update("booking", values, "bookingId=?", new String[]{booking.getBookingId()});
        db.close();
    }

    public ArrayList<Booking> getAllBookings()
    {
        ArrayList<Booking> bookings=new ArrayList<Booking>();
        String selectQuery = "SELECT  * FROM booking";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Booking booking;
                booking = new Booking(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getString(19));
                bookings.add(booking);
            }while(cursor.moveToNext());
        }
        db.close();
        return bookings;
    }

    public void deleteBookings(String bookingId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("booking", "bookingId" + "=" + bookingId, null);
        db.close();
    }





    //Methods for Committee ******************************************************************************************

    public void addCommittee(Committee committee)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("committeeId",committee.getCommitteeId());
        values.put("name",committee.getName());
        values.put("designation",committee.getDesignation());
        values.put("description", committee.getDescription());
        values.put("showContact",committee.getShowContact());
        values.put("contactNo",committee.getContactNo());
        values.put("societyId",committee.getSocietyId());
        values.put("buildingId",committee.getBuildingId());
        values.put("flatNo",committee.getFlatNo());

        // Inserting Row
        db.insert("committee", null, values);
        db.close(); // Closing database connection

    }

    public Committee getCommittee(String committeeId)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("committee", new String[]{}, "committeeId" + "=?",
                new String[]{committeeId}, null, null, null, null);
        Committee committee = new Committee();
        if (cursor != null && cursor.moveToFirst()) {
            committee = new Committee(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
        }
        db.close();
        return committee;
    }

    public void deleteAllCommittees() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("committee", null, null);
        db.close();
    }

    public void updateCommittee(Committee committee)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("committeeId",committee.getCommitteeId());
        values.put("name",committee.getName());
        values.put("designation",committee.getDesignation());
        values.put("description", committee.getDescription());
        values.put("showContact",committee.getShowContact());
        values.put("contactNo",committee.getContactNo());
        values.put("societyId",committee.getSocietyId());
        values.put("buildingId",committee.getBuildingId());
        values.put("flatNo",committee.getFlatNo());


        db.update("committee", values, "committeeId=?", new String[]{committee.getCommitteeId()});
        db.close();
    }

    public ArrayList<Committee> getAllCommittees()
    {
        ArrayList<Committee> committees=new ArrayList<Committee>();
        String selectQuery = "SELECT  * FROM committee";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Committee committee;
                committee = new Committee(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8));
                committees.add(committee);
            }while(cursor.moveToNext());
        }
        db.close();
        return committees;
    }

    public void deleteCommittee(String committeeId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("committee", "committeeId" + "=" + committeeId, null);
        db.close();
    }



}

