package com.example.demo;

import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private BookingRepository bookingRepository;

	@Test
	void BookingTest() throws Exception {

		// SetBooking
//		mockMvc.perform( MockMvcRequestBuilders.post("/api/v1/booking")
//						.content(asJsonString(new BookingModel(1l, 1l)))
//						.contentType(MediaType.APPLICATION_JSON)
//						.accept(MediaType.APPLICATION_JSON))
//						.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

		// GetAllBooking
//		mockMvc.perform(get("/api/v1/booking"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$[0].id").value("102"))
//				.andReturn();

		// GetBooking
//		mockMvc.perform(get("/api/v1/booking", "123=456")
//						.param("movieid", new String("1")))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.movieId").value("1"))
//				.andReturn();
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

//	@Test
//	void CustomerTest() throws Exception {
//		String actual ="";
//	}
//
//	@Test
//	void MovieTest() throws Exception {
//		String actual ="";
//	}

}
