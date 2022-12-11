/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package wolfadam.etterem.WareHouse.datamodel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Egy árú
 * @author fluxu
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Product {

    private String name;
    private String description;
    private int purchasePrice;
    private int amount;
    private List<String> imageurls= new ArrayList<>();
    private LocalDate expirationDate;
    private WareHouse warehouse;
    
@Builder  
    public Product(String name, int purchasePrice, int amount, LocalDate expirationDate) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.amount = amount;
        this.expirationDate = expirationDate;
    }
 
}
