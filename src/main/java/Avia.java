import model.Tickets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Avia {
    private static List<Tickets> tickets = new ArrayList<>();
    private static List<Integer> averageHours = new ArrayList<>();

    public static void main(String[] args) {

        parse(args[0]);
        averageFlightTime();

    }

    public static void parse(String path) {

        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(path);

            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray jsonArray = (JSONArray) jsonObject.get("tickets");


            for (Object it : jsonArray) {
                JSONObject ticketsObject = (JSONObject) it;
                Tickets ticket = new Tickets();
                ticket.setOrigin((String) ticketsObject.get("origin"));
                ticket.setOriginName((String) ticketsObject.get("origin_name"));
                ticket.setDesination((String) ticketsObject.get("destination"));
                ticket.setDesinationName((String) ticketsObject.get("destination_name"));
                ticket.setDeparture_date((String) ticketsObject.get("departure_date"));
                ticket.setDeparture_time((String) ticketsObject.get("departure_time"));
                ticket.setArrival_time((String) ticketsObject.get("arrival_time"));
                ticket.setArrival_date((String) ticketsObject.get("arrival_date"));
                ticket.setCarrier((String) ticketsObject.get("carrier"));
                ticket.setStops((Long) ticketsObject.get("stops"));
                ticket.setPrice((Long) ticketsObject.get("price"));
                tickets.add(ticket);
            }
        } catch (Exception e) {
            System.out.println("parsing error" + e.toString());
        }
    }

    public static void averageFlightTime() {

        for (Tickets ticket : tickets) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
            String departureTime = ticket.getDeparture_date() + " " + ticket.getDeparture_time();
            LocalDateTime departure = LocalDateTime.parse(departureTime, formatter);
            String arrivalTime = ticket.getArrival_date() + " " + ticket.getArrival_time();
            LocalDateTime arrival = LocalDateTime.parse(arrivalTime, formatter);


            int averageTime = arrival.getHour() - departure.getHour();
            System.out.println(ticket.getOriginName()+" from to "+ticket.getDesinationName() + " average time= " + averageTime + " hours");
            averageHours.add(averageTime);
        }

        long percentile = percentile(averageHours, 90);
        System.out.println("90-percentile= " + percentile + " hours");

    }

    public static long percentile(List<Integer> latencies, double percentile) {
        Collections.sort(latencies);
        int index = (int) Math.ceil(percentile / 100.0 * latencies.size());

        return latencies.get(index - 1);
    }
}
