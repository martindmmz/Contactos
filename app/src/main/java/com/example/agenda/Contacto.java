package com.example.agenda;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

public class Contacto implements Parcelable {

    public String nombre;
    public String telefono;
    public String correo;
    public String fecha;
    public String twitter;

    public Contacto(String nombre, String telefono, String correo, String fecha, String twitter) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha = fecha;
        this.twitter = twitter;
    }

    protected Contacto(Parcel in) {
        nombre = in.readString();
        telefono = in.readString();
        correo = in.readString();
        fecha = in.readString();
        twitter = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeString(correo);
        dest.writeString(fecha);
        dest.writeString(twitter);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>() {

        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    @Override
    public String toString(){
        return this.nombre+"\n"+this.correo;

    }

}