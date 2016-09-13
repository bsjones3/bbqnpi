package org.pi.bbq.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@RequestMapping(value = "/temperature_query.json", method = RequestMethod.GET)
//	public List<Temperature> listTemperatures(
//			@RequestParam(value = "num_sens") int sensnum) {
//
//		List<Temperature> temperatures = new ArrayList<Temperature>();
//
//		/*
//		 * SELECT * from (SELECT timestamp*1000 as x, sensnum, temp as y FROM
//		 * temps where sensnum = ? and timestamp >= strftime('%s', 'now') - 3600
//		 * ORDER BY x DESC LIMIT ?) ORDER BY x ASC;
//		 */
//
//		jdbcTemplate
//				.query("SELECT times, sensnum, temp from (SELECT time*1000 as times, sensnum, temp FROM temps where sensnum = ? and time >= strftime('%s', 'now') - 3600 ORDER BY times DESC) ORDER BY times ASC",
//						new Object[] { sensnum },
//						// "SELECT time, sensnum, temp FROM temps where sensnum = ? ",
//						// new Object[] { sensnum },
//						(rs, rowNum) -> new Temperature(rs
//								.getTimestamp("times"), rs.getInt("sensnum"),
//								rs.getInt("temp"))).forEach(
//						temps -> temperatures.add(temps));
//
//		return temperatures;
//	}
//
//	@RequestMapping(value = "/temperature_now.json", method = RequestMethod.GET)
//	public Temperature_record listTemperaturesNow(
//			@RequestParam(value = "num_sens") int sensnum) {
//
//		List<Temperature> temperatures = new ArrayList<Temperature>();
//
//		jdbcTemplate
//				.query("SELECT (MAX(time)*1000) as time, sensnum, temp from temperatures where sensnum = ?",
//						new Object[] { sensnum },
//						// "SELECT time, sensnum, temp FROM temps where sensnum = ? and time = (Select max(time) from temps where time <= CURRENT_TIMESTAMP and sensnum = ?)",
//						// new Object[] { sensnum, sensnum },
//						(rs, rowNum) -> new Temperature(
//								rs.getTimestamp("time"), rs.getInt("sensnum"),
//								rs.getInt("temp"))).forEach(
//						temps -> temperatures.add(temps));
//
//		Temperature_record temp = new Temperature_record();
//		temp.setTemperature(temperatures);
//
//		return temp;
//	}
//
//	@RequestMapping(value = "/temperatures.json", method = RequestMethod.GET)
//	public String generateDataTableTemperatures(
//			@RequestParam(value = "num_sens") int sensnum) {
//		// Create a data table.
//		DataTable data = new DataTable();
//		ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
//		cd.add(new ColumnDescription("time", ValueType.DATETIME, "Time"));
//		cd.add(new ColumnDescription("temperature", ValueType.NUMBER,
//				"Temperature"));
//
//		data.addColumns(cd);
//
//		// Fill the data table.
//		try {
//
//			List<Temperature> temperatures = new ArrayList<Temperature>();
//
//			/*
//			 * SELECT * from (SELECT timestamp*1000 as x, sensnum, temp as y
//			 * FROM temps where sensnum = ? and timestamp >= strftime('%s',
//			 * 'now') - 3600 ORDER BY x DESC LIMIT ?) ORDER BY x ASC;
//			 */
//
//			jdbcTemplate
//					.query("SELECT times, sensnum, temp from (SELECT time*1000 as times, sensnum, temp FROM temperatures where sensnum = ? and time >= strftime('%s', 'now') - 3600 ORDER BY times DESC) ORDER BY times ASC",
//							new Object[] { sensnum },
//							(rs, rowNum) -> new Temperature(rs
//									.getTimestamp("times"), rs
//									.getInt("sensnum"), rs.getInt("temp")))
//					.forEach(temps -> temperatures.add(temps));
//
//			for (Temperature temp : temperatures) {
//
//				com.ibm.icu.util.GregorianCalendar cal = new com.ibm.icu.util.GregorianCalendar(temp.getTime().getYear(), temp.getTime().getMonth(), temp.getTime().getDay(), temp.getTime().getHours(), temp.getTime().getMinutes(), temp.getTime().getSeconds());
//				cal.setTimeZone(com.ibm.icu.util.TimeZone.getTimeZone("GMT"));
//				System.out.println("Time: " + cal + " Temp: "+temp.getTemp());
//				data.addRowFromValues(cal, temp.getTemp());
//			}
//		} catch (TypeMismatchException e) {
//			System.out.println("Invalid type! " + e);
//		}
//
//		CharSequence charSequence = JsonRenderer.renderDataTable(data, true,
//				true, true);
//		return charSequence.toString();
//	}
//
//	@RequestMapping(value = "/temperature_all.json", method = RequestMethod.GET)
//	public String generateDataTable() {
//		// Create a data table.
//		DataTable data = new DataTable();
//		ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
//		cd.add(new ColumnDescription("name", ValueType.TEXT, "Animal name"));
//		cd.add(new ColumnDescription("link", ValueType.TEXT, "Link to wikipedia"));
//		cd.add(new ColumnDescription("population", ValueType.NUMBER,"Population size"));
//	    cd.add(new ColumnDescription("vegeterian", ValueType.BOOLEAN,"Vegetarian?"));
//
//		data.addColumns(cd);
//
//		// Fill the data table.
//		try {
//			 data.addRowFromValues("Aye-aye",
//			 "http://en.wikipedia.org/wiki/Aye-aye", 100, true);
//			 data.addRowFromValues("Sloth",
//			 "http://en.wikipedia.org/wiki/Sloth", 300, true);
//			 data.addRowFromValues("Leopard",
//			 "http://en.wikipedia.org/wiki/Leopard", 50, false);
//			 data.addRowFromValues("Tiger",
//			 "http://en.wikipedia.org/wiki/Tiger", 80, false);
//		} catch (TypeMismatchException e) {
//			System.out.println("Invalid type!");
//		}
//
//		CharSequence charSequence = JsonRenderer.renderDataTable(data, true,
//				true, true);
//		return charSequence.toString();
//	}
}
