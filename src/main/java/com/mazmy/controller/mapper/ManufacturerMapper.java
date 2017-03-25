package com.mazmy.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mazmy.datatransferobject.ManufacturerDTO;
import com.mazmy.domainobject.ManufacturerDO;

public class ManufacturerMapper {

	public static ManufacturerDO makeManufacturerDO(ManufacturerDTO manufacturerDTO) {
		return new ManufacturerDO(manufacturerDTO.getManufacturer());
	}
	
	public static ManufacturerDTO makeManufacturerDTO(ManufacturerDO manufacturerDO) {
		ManufacturerDTO.ManufacturerDTOBuilder manufacturerDTOBuilder = ManufacturerDTO.newBuilder()
				.setId(manufacturerDO.getId())
				.setManufacturer(manufacturerDO.getManufacturer());
		return manufacturerDTOBuilder.createManufacturerDO();
	}
	
	public static List<ManufacturerDTO> makeManufacturerList(Collection<ManufacturerDO> manufacturers) {
        return manufacturers.stream()
            .map(ManufacturerMapper::makeManufacturerDTO)
            .collect(Collectors.toList());
    }
}
