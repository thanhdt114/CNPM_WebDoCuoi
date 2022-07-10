package support;

import java.text.DecimalFormat;

/**
 *
 * @author thanh
 */
public class CartSP {
    private String image;
    private String nameProduct;
    private Double donGia;
    private Double soLuong;
    private String idProduct;
    
    public CartSP() {
        
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }
    
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    
    public void setDonGia(double price) {
        this.donGia = price;
    }
    public double getDonGia() {
        return donGia;
    }
    
    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }
    public double getSoLuong() {
        return soLuong;
    }
    
    public void setIDProduct(String idProduct) {
        this.idProduct = idProduct;
    }
    public String getIDProduct() {
        return idProduct;
    }
    
        public String getPriceCurrencyFormat() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((donGia));
    }
    
    public String getTotalCurrencyFormat() {
        double total = soLuong * donGia;
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((total));
    }
    
    public String getSoLuongCurrencyFormat() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((soLuong));
    }
}
