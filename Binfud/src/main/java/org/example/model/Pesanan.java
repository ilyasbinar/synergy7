package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pesanan {
    private long id;
    private String kode;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private List<ItemPesanan> itemPesananList;
}
