/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.datamodel;

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
    private byte id;
    private int capacity;
    private byte temperature;
    
    @Builder
    public Fridge(String name, byte id, int capacity, byte temperature) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.temperature = temperature;
    }
}
