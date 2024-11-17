package com.poly.Service.Implement;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.DAO.BookingDAO;
import com.poly.DAO.BookingDetailDAO;
import com.poly.Entity.Booking;
import com.poly.Entity.BookingDetail;

import com.poly.Service.BookingService;

import aj.org.objectweb.asm.TypeReference;
@Service
public class BookingServiceIML implements BookingService {
		@Autowired
		BookingDAO bDao;
		@Autowired
		BookingDetailDAO bdDao;
		@Override
		public Booking create(JsonNode bookingData) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.getFactory().setStreamWriteConstraints(StreamWriteConstraints.builder().maxNestingDepth(2000).build());
			// fiel json co du lieu service nhung trong  booking khong co doi tuong service , chinh xac xu ly them 
			Booking booking = mapper.convertValue(bookingData, Booking.class);
			
			bDao.save(booking);
			com.fasterxml.jackson.core.type.TypeReference<List<BookingDetail>> type = new com.fasterxml.jackson.core.type.TypeReference<List<BookingDetail>>() {
			};
			List<BookingDetail>  details = (List<BookingDetail>) mapper.convertValue(bookingData.get("bookingDetails"),type)
					.stream().peek(d -> d.setBooking(booking)).collect(Collectors.toList());
			bdDao.saveAll(details);
			
			return bDao.save(booking);
		}
		@Override
		public Booking findByID(Integer id) {
			
			return  bDao.findById(id).get();
		}
		@Override
		public List<Booking> findBookingByUserName(String username) {
			
			return bDao.findByUserName(username);
		}
	

}
