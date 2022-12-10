/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wolfadam.etterem.WareHouse.datamodel;


import java.util.ArrayList;
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
public class WareHouse {
private String name;
private List<Shelf> shelves;
private List<Fridge> fridges;
private String location;

@Builder
public WareHouse(String name, String location){
        this.fridges = new ArrayList<>();
        this.shelves = new ArrayList<>();
    this.name = name;
    this.location = location;
}
}
