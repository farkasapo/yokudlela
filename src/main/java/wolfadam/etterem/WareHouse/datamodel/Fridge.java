/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.datamodel;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author fluxu
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Fridge {
    private String name;
    private int capacity;
    private byte temperature;
     private List<Product> products;
    
    @Builder
    public Fridge(String name, int capacity, byte temperature) {
        this.name = name;
        this.capacity = capacity;
        this.temperature = temperature;
    }

     public int getActualCapacity() {
       
    return this.capacity;
    }
    
     public String getName() {
       
    return this.name;
    }

    public void setActualCapacity(int newCapacity) {
        
        this.capacity = newCapacity;   
    }
    
    
}
