package model.dto;

import java.util.ArrayList;
import java.util.List;

public class ItemListDTO {
    private List<ItemDTO> itemList;

    public ItemListDTO(List<ItemDTO> itemList) {
        itemList = new ArrayList<>();
    }
}
