package com.maverikteam.maverik.DTO;

import com.maverikteam.maverik.model.Empresa;
import lombok.Data;

@Data
public class PlainEmpresaDTO {
    private Integer id;
    private String name;

    public static PlainEmpresaDTO from(Empresa empresa){
        PlainEmpresaDTO empresaPert = new PlainEmpresaDTO();
        empresaPert.setId(empresa.getId_ent());
        empresaPert.setName(empresa.getNombre());
        return empresaPert;

    }
}
