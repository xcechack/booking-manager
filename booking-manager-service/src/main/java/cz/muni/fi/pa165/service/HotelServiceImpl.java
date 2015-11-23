package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.HotelDao;
import cz.muni.fi.pa165.dto.HotelDto;
import cz.muni.fi.pa165.entity.Hotel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jana Cechackova
 */
@Service("hotelService")
public class HotelServiceImpl implements HotelService{
    
    HotelDao hotelDao;
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public void addHotel(HotelDto hotelDto) {
	
	Hotel hotel;
	
	hotel = mapper.map(hotelDto, Hotel.class);
//	hotelDto.setId(hotel.getId());   not included because the method is not implemented yet
	hotelDao.addHotel(hotel);    
    }

    @Override
    public void deleteHotel(HotelDto hotelDto) {
	
	Hotel hotel;
	
	hotel = mapper.map(hotelDto, Hotel.class);
	hotelDao.deleteHotel(hotel);    
    }

    @Override
    public void updateHotel(HotelDto hotelDto) {
	
	Hotel hotel;
    
	hotel = mapper.map(hotelDto, Hotel.class);
	hotelDao.updateHotel(hotel);
    }

    @Override
    public HotelDto getHotelDtoById(Long id) {
	
	//not implemented yet
	
	return null;    
    } 
}
