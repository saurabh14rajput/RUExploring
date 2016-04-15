package com.manjusha.saurabh.ruexploring.dummy;

import android.graphics.drawable.Drawable;

import com.manjusha.saurabh.ruexploring.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
    //DummyItem museum;

    static {
        createDummyItem();

        }

    private static void createDummyItem() {
        DummyItem museum = new DummyItem("0",
                "Zimmerli Art Museum",
                "The Zimmerli is a teaching museum with diverse collections and dynamic programming which offer something for everyone. With more than 60,000 works in its collection, the museum frequently updates the permanent galleries with works that spotlight an artist, period, or theme. Special exhibitions reflect the Zimmerli's commitment to interdisciplinary perspectives and range from provocative thematic shows to in-depth surveys of particular artists and movements Educational activities and social opportunities enhance the visual experience for visitors of all ages. Performances and lectures provide deeper insight into the artist's world; while workshops and classes invite participants to become the artists.",
                "Voorhees Hall, 71 Hamilton St New Brunswick, NJ 08901",
                40.500201,
                -74.445859,
                "Tuesdays through Fridays: 10am to 4:30pm. Saturdays and Sundays: Noon to 5pm. First Tuesdays of the month: 10am to 9pm",
                "January 1, July 4, Thanksgiving Thursday and Friday, December 24 after 2pm, and December 25",
                R.drawable.zimmerli);
                addItem(museum);
        DummyItem cabaretTheatre = new DummyItem("1",
                "Cabaret Theatre",
                "Since 1975, Cabaret Theatre has been committed to providing the university and its surrounding community with a wide variety of theatrical experiences, as well as offering a forum for students to learn about acting, directing, writing, business management, design and construction through various workshops and hands-on experience",
                "7 Suydam St, New Brunswick, NJ 08901",
                40.483853,
                -74.438940,
                "As per show schedules",
                "As per show schedules",
                R.drawable.cabaret);
        addItem(cabaretTheatre);
        DummyItem stadium = new DummyItem("2",
                "High Point Solutions Stadium",
                "The crown jewel venue of Rutgers Athletics is now called High Point Solutions Stadium. Formed in July of 1996, High Point Solutions, Inc. was created to meet the specific needs of the Fortune 500 and service provider industries and has rapidly become known as a leader in the Information Technology and service sectors. As a specialist IT Services and Solutions provider, High Point partners with clients in planning, building and supporting their IT infrastructures",
                "1 Scarlet Knight Way, Piscataway Township, NJ 08854",
                40.514377,
                -74.465616,
                "As per match schedule",
                "As per match schedule",
                R.drawable.stadium);
        addItem(stadium);
        DummyItem rutgersCinema = new DummyItem("3",
                "Rutgers Cinema",
                "Rutgers Cinema is a state-of-the-art digital theater located in a new mixed-use retail plaza on the Livingston Campus of Rutgers, The State University of New Jersey, in Piscataway.  The new development is a pedestrian-friendly gathering place where the Rutgers community will come together to eat, study, play, and shop and includes an expansive green space to host community events.  The Cinema is surrounded by eateries, a technology store, a fresh grocer, a coffee bar, a nail salon, and a full-service diner",
                "105 Joyce Kilmer Ave, Piscataway Township, NJ 08854",
                40.525446,
                -74.437177,
                "As per movie schedule",
                "As per movie schedule",
                R.drawable.cinema);
        addItem(rutgersCinema);
        DummyItem kirkpatrickChapel = new DummyItem("4",
                "Kirkpatrick Chapel",
                "Kirkpatrick Chapel was built in 1873 in memory of Sophia Astley Kirkpatrick of New Brunswick, New Jersey. She was the wife of Littleton Kirkpatrick, trustee of Rutgers College from 1841–1859. Rutgers College was made a residuary legatee of her estate, and the chapel was funded by her gift of $61,054.57. This marked the first time in New Jersey history that an institution became heir to an estate. The chapel was designed by Henry Janeway Hardenbergh, the great-great-grandson of Jacob Rutsen Hardenbergh, the first president of Rutgers College. The New Jersey Historic Trust notes that the chapel “is an excellent example of High Victorian Gothic ecclesiastical architecture…and the chapel’s stained glass windows contain some of the first opalescent and multicolored sheet glass manufactured in America.” Four of the chapel windows are from the studios of Louis Comfort Tiffany and date back to the late 19th century.",
                "71 Hamilton St, New Brunswick, NJ 08901",
                 40.499056,
                -74.445862,
                "Monday through Friday. 9 a.m. to 4 p.m",
                "Saturday and Sunday",
                R.drawable.chapel);
        addItem(kirkpatrickChapel);
        DummyItem rutgersGardens = new DummyItem("5",
                "Rutgers Gardens",
                "This year, 2016, marks the 100th year that the Gardens and the surrounding area known as Horticultural Farm Number 1 was purchased by Rutgers University.  Its initial mission was for plant research and for the display of plants to local farmers in the hopes of expanding the emerging nursery industry.  For 100 years, Horticultural Farm Number 1 has churned out wonderful selections of Peach, Apple, Asparagus, Holly, Dogwood, and of late, Hazelnut. The Gardens displayed selections of Iris, shrubs, trees and, more recently, annuals, perennials and vegetables. To embrace this remarkable history, while looking towards the next 100 years, the Gardens is unveiling a new mission statement: Rutgers Gardens cultivates inquisitive minds, great plants, and inspired gardening through educational exploration and enjoyment",
                "112 Ryders Ln, New Brunswick, NJ 08901",
                40.473988,
                -74.423139,
                "Monday through Sunday. 8 a.m. to 6 p.m",
                "Saturday and Sunday",
                R.drawable.gardens);
        addItem(rutgersGardens);

    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getHours() {
            return hours;
        }

        public void setHours(String hours) {
            this.hours = hours;
        }

        public String getClosedOn() {
            return closedOn;
        }

        public void setClosedOn(String closedOn) {
            this.closedOn = closedOn;
        }

        public int getImageName() {
            return imageID;
        }


        public String id;
        public String content;
        public String details;
        public String address;
        public double latitude;
        public double longitude;
        public String hours;
        public String closedOn;
        public int imageID;

        public DummyItem(String id, String content, String details,String address ,double latitude, double longitude, String hours, String closedOn,int imageID) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.address=address;
            this.latitude=latitude;
            this.longitude=longitude;
            this.hours=hours;
            this.closedOn=closedOn;
            this.imageID=imageID;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
