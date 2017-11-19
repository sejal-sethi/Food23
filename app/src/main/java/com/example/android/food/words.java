package com.example.android.food;



public class words {
    private String nameOfItem;
    private int priceOfItem;
    private int quantityOfItem=0;
    private  int resid;

    public words( String mdefault_translation,int m_translation,int resoid){
        nameOfItem=mdefault_translation;
        priceOfItem=m_translation;
        resid=resoid;
    }
    words(){

    }
    public int getresource(){
        return resid;
    }
    public String getNameOfItem(){
        return nameOfItem;
    }
    public int getPriceOfItem(){
        return priceOfItem;
    }
    public int getQuantityOfItem(){
        return quantityOfItem;
    }


}
