package fr.wildcodeschool.blablawild2;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        RecyclerView listItineraries = findViewById(R.id.list_itineraries);
// TODO : préciser le type de layout de la liste

        final ArrayList<ItineraryModel> itineraryModels = new ArrayList<>();
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Eric Cartman", new Date(), 15));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Stan Marsh", new Date(), 20));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kenny Broflovski", new Date(), 12));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kyle McCormick", new Date(), 18));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Wendy Testaburger", new Date(), 16));

// TODO : afficher la liste d'itinéraires avec un adapter
        final ItineraryRecyclerAdapter adapter = new ItineraryRecyclerAdapter(itineraryModels);
        listItineraries.setAdapter(adapter);

        listItineraries.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), listItineraries, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Toast.makeText(getApplicationContext(), itineraryModels.get(position).getDriver() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


// TODO : préciser le type de layout de la liste
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listItineraries.setLayoutManager(layoutManager);
    }

    /**
     * Created by bastienwcs on 15/04/18.
     */

    public static class ItineraryModel {

        private String departure;
        private String destination;
        private String driver;
        private Date date;
        private int price;

        public ItineraryModel(String departure, String destination, String driver, Date date, int price) {
            this.departure = departure;
            this.destination = destination;
            this.driver = driver;
            this.date = date;
            this.price = price;
        }

        public String getDeparture() {
            return departure;
        }

        public String getDestination() {
            return destination;
        }

        public String getDriver() {
            return driver;
        }

        public Date getDate() {
            return date;
        }

        public int getPrice() {
            return price;
        }

        public ItineraryModel() {
        }

    }
}
