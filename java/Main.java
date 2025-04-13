import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Check if exactly two arguments are provided
        if (args.length != 2) {
            System.err.println("Usage: java Main <source_station> <destination_station>");
            System.exit(1);
        }

        String source = args[0];
        String destination = args[1];

        int v = 250; // Total number of vertices
        MetroGraph metroGraph = new MetroGraph(v);

        // Blue Line (Line 3) - Main Line
        metroGraph.addEdge("Dwarka Sector 21", "Dwarka Sector 8", 3, "Blue");
        metroGraph.addEdge("Dwarka Sector 8", "Dwarka Sector 9", 2, "Blue");
        metroGraph.addEdge("Dwarka Sector 9", "Dwarka Sector 10", 2, "Blue");
        metroGraph.addEdge("Dwarka Sector 10", "Dwarka Sector 11", 2, "Blue");
        metroGraph.addEdge("Dwarka Sector 11", "Dwarka Sector 12", 2, "Blue");
        metroGraph.addEdge("Dwarka Sector 12", "Dwarka Sector 13", 2, "Blue");
        metroGraph.addEdge("Dwarka Sector 13", "Dwarka Sector 14", 2, "Blue");
        metroGraph.addEdge("Dwarka Sector 14", "Dwarka", 3, "Blue");
        metroGraph.addEdge("Dwarka", "Dwarka Mor", 3, "Blue");
        metroGraph.addEdge("Dwarka Mor", "Nawada", 3, "Blue");
        metroGraph.addEdge("Nawada", "Uttam Nagar West", 3, "Blue");
        metroGraph.addEdge("Uttam Nagar West", "Uttam Nagar East", 2, "Blue");
        metroGraph.addEdge("Uttam Nagar East", "Janakpuri West", 3, "Blue");
        metroGraph.addEdge("Janakpuri West", "Janakpuri East", 2, "Blue");
        metroGraph.addEdge("Janakpuri East", "Tilak Nagar", 2, "Blue");
        metroGraph.addEdge("Tilak Nagar", "Subhash Nagar", 2, "Blue");
        metroGraph.addEdge("Subhash Nagar", "Tagore Garden", 2, "Blue");
        metroGraph.addEdge("Tagore Garden", "Rajouri Garden", 2, "Blue");
        metroGraph.addEdge("Rajouri Garden", "Ramesh Nagar", 2, "Blue");
        metroGraph.addEdge("Ramesh Nagar", "Moti Nagar", 2, "Blue");
        metroGraph.addEdge("Moti Nagar", "Kirti Nagar", 2, "Blue");
        metroGraph.addEdge("Kirti Nagar", "Shadipur", 2, "Blue");
        metroGraph.addEdge("Shadipur", "Patel Nagar", 2, "Blue");
        metroGraph.addEdge("Patel Nagar", "Rajendra Place", 2, "Blue");
        metroGraph.addEdge("Rajendra Place", "Karol Bagh", 2, "Blue");
        metroGraph.addEdge("Karol Bagh", "Jhandewalan", 2, "Blue");
        metroGraph.addEdge("Jhandewalan", "Ramakrishna Ashram Marg", 2, "Blue");
        metroGraph.addEdge("Ramakrishna Ashram Marg", "Rajiv Chowk", 2, "Blue");
        metroGraph.addEdge("Rajiv Chowk", "Barakhamba Road", 2, "Blue");
        metroGraph.addEdge("Barakhamba Road", "Mandi House", 2, "Blue");
        metroGraph.addEdge("Mandi House", "Supreme Court", 2, "Blue");
        metroGraph.addEdge("Supreme Court", "Indraprastha", 2, "Blue");
        metroGraph.addEdge("Indraprastha", "Yamuna Bank", 3, "Blue");

        // Blue Line Branch (Towards Vaishali)
        metroGraph.addEdge("Yamuna Bank", "Laxmi Nagar", 2, "Blue");
        metroGraph.addEdge("Laxmi Nagar", "Nirman Vihar", 2, "Blue");
        metroGraph.addEdge("Nirman Vihar", "Preet Vihar", 2, "Blue");
        metroGraph.addEdge("Preet Vihar", "Karkarduma", 2, "Blue");
        metroGraph.addEdge("Karkarduma", "Anand Vihar ISBT", 2, "Blue");
        metroGraph.addEdge("Anand Vihar ISBT", "Kaushambi", 2, "Blue");
        metroGraph.addEdge("Kaushambi", "Vaishali", 2, "Blue");

        // Blue Line Branch (Towards Noida Electronic City)
        metroGraph.addEdge("Yamuna Bank", "Akshardham", 2, "Blue");
        metroGraph.addEdge("Akshardham", "Mayur Vihar Phase-1", 2, "Blue");
        metroGraph.addEdge("Mayur Vihar Phase-1", "Mayur Vihar Extension", 2, "Blue");
        metroGraph.addEdge("Mayur Vihar Extension", "New Ashok Nagar", 2, "Blue");
        metroGraph.addEdge("New Ashok Nagar", "Noida Sector 15", 2, "Blue");
        metroGraph.addEdge("Noida Sector 15", "Noida Sector 16", 2, "Blue");
        metroGraph.addEdge("Noida Sector 16", "Noida Sector 18", 2, "Blue");
        metroGraph.addEdge("Noida Sector 18", "Botanical Garden", 2, "Blue");
        metroGraph.addEdge("Botanical Garden", "Golf Course", 2, "Blue");
        metroGraph.addEdge("Golf Course", "Noida City Centre", 2, "Blue");
        metroGraph.addEdge("Noida City Centre", "Noida Sector 34", 2, "Blue");
        metroGraph.addEdge("Noida Sector 34", "Noida Sector 52", 2, "Blue");
        metroGraph.addEdge("Noida Sector 52", "Noida Sector 61", 2, "Blue");
        metroGraph.addEdge("Noida Sector 61", "Noida Sector 59", 2, "Blue");
        metroGraph.addEdge("Noida Sector 59", "Noida Sector 62", 2, "Blue");
        metroGraph.addEdge("Noida Sector 62", "Noida Electronic City", 2, "Blue");

        // Yellow Line (Line 2)
        metroGraph.addEdge("Samaypur Badli", "Rohini Sector 18,19", 3, "Yellow");
        metroGraph.addEdge("Rohini Sector 18,19", "Haiderpur Badli Mor", 2, "Yellow");
        metroGraph.addEdge("Haiderpur Badli Mor", "Jahangirpuri", 2, "Yellow");
        metroGraph.addEdge("Jahangirpuri", "Adarsh Nagar", 2, "Yellow");
        metroGraph.addEdge("Adarsh Nagar", "Azadpur", 2, "Yellow");
        metroGraph.addEdge("Azadpur", "Model Town", 2, "Yellow");
        metroGraph.addEdge("Model Town", "GTB Nagar", 2, "Yellow");
        metroGraph.addEdge("GTB Nagar", "Vishwavidyalaya", 2, "Yellow");
        metroGraph.addEdge("Vishwavidyalaya", "Vidhan Sabha", 2, "Yellow");
        metroGraph.addEdge("Vidhan Sabha", "Civil Lines", 2, "Yellow");
        metroGraph.addEdge("Civil Lines", "Kashmere Gate", 2, "Yellow");
        metroGraph.addEdge("Kashmere Gate", "Chandni Chowk", 2, "Yellow");
        metroGraph.addEdge("Chandni Chowk", "Chawri Bazar", 2, "Yellow");
        metroGraph.addEdge("Chawri Bazar", "New Delhi", 2, "Yellow");
        metroGraph.addEdge("New Delhi", "Rajiv Chowk", 2, "Yellow");
        metroGraph.addEdge("Rajiv Chowk", "Patel Chowk", 2, "Yellow");
        metroGraph.addEdge("Patel Chowk", "Central Secretariat", 2, "Yellow");
        metroGraph.addEdge("Central Secretariat", "Udyog Bhawan", 2, "Yellow");
        metroGraph.addEdge("Udyog Bhawan", "Lok Kalyan Marg", 2, "Yellow");
        metroGraph.addEdge("Lok Kalyan Marg", "Jor Bagh", 2, "Yellow");
        metroGraph.addEdge("Jor Bagh", "INA", 2, "Yellow");
        metroGraph.addEdge("INA", "AIIMS", 2, "Yellow");
        metroGraph.addEdge("AIIMS", "Green Park", 2, "Yellow");
        metroGraph.addEdge("Green Park", "Hauz Khas", 2, "Yellow");
        metroGraph.addEdge("Hauz Khas", "Malviya Nagar", 2, "Yellow");
        metroGraph.addEdge("Malviya Nagar", "Saket", 2, "Yellow");
        metroGraph.addEdge("Saket", "Qutab Minar", 2, "Yellow");
        metroGraph.addEdge("Qutab Minar", "Chattarpur", 3, "Yellow");
        metroGraph.addEdge("Chattarpur", "Sultanpur", 3, "Yellow");
        metroGraph.addEdge("Sultanpur", "Ghitorni", 3, "Yellow");
        metroGraph.addEdge("Ghitorni", "Arjangarh", 3, "Yellow");
        metroGraph.addEdge("Arjangarh", "Guru Dronacharya", 2, "Yellow");
        metroGraph.addEdge("Guru Dronacharya", "Sikanderpur", 2, "Yellow");
        metroGraph.addEdge("Sikanderpur", "MG Road", 2, "Yellow");
        metroGraph.addEdge("MG Road", "IFFCO Chowk", 2, "Yellow");
        metroGraph.addEdge("IFFCO Chowk", "HUDA City Centre", 3, "Yellow");

        // Red Line (Line 1)
        metroGraph.addEdge("Rithala", "Rohini West", 3, "Red");
        metroGraph.addEdge("Rohini West", "Rohini East", 2, "Red");
        metroGraph.addEdge("Rohini East", "Pitampura", 2, "Red");
        metroGraph.addEdge("Pitampura", "Kohat Enclave", 2, "Red");
        metroGraph.addEdge("Kohat Enclave", "Netaji Subhash Place", 2, "Red");
        metroGraph.addEdge("Netaji Subhash Place", "Keshav Puram", 2, "Red");
        metroGraph.addEdge("Keshav Puram", "Kanhaiya Nagar", 2, "Red");
        metroGraph.addEdge("Kanhaiya Nagar", "Inderlok", 2, "Red");
        metroGraph.addEdge("Inderlok", "Shastri Nagar", 2, "Red");
        metroGraph.addEdge("Shastri Nagar", "Pratap Nagar", 2, "Red");
        metroGraph.addEdge("Pratap Nagar", "Pulbangash", 2, "Red");
        metroGraph.addEdge("Pulbangash", "Tis Hazari", 2, "Red");
        metroGraph.addEdge("Tis Hazari", "Kashmere Gate", 2, "Red");
        metroGraph.addEdge("Kashmere Gate", "Shastri Park", 2, "Red");
        metroGraph.addEdge("Shastri Park", "Seelampur", 2, "Red");
        metroGraph.addEdge("Seelampur", "Welcome", 2, "Red");
        metroGraph.addEdge("Welcome", "Shahdara", 2, "Red");
        metroGraph.addEdge("Shahdara", "Mansarovar Park", 2, "Red");
        metroGraph.addEdge("Mansarovar Park", "Jhilmil", 2, "Red");
        metroGraph.addEdge("Jhilmil", "Dilshad Garden", 2, "Red");
        metroGraph.addEdge("Dilshad Garden", "Shaheed Nagar", 2, "Red");
        metroGraph.addEdge("Shaheed Nagar", "Raj Bagh", 2, "Red");
        metroGraph.addEdge("Raj Bagh", "Shiv Vihar", 3, "Red");

        // Green Line (Line 5)
        metroGraph.addEdge("Kirti Nagar", "Satguru Ram Singh Marg", 2, "Green");
        metroGraph.addEdge("Satguru Ram Singh Marg", "Inderlok", 2, "Green");
        metroGraph.addEdge("Inderlok", "Ashok Park Main", 2, "Green");
        metroGraph.addEdge("Ashok Park Main", "Punjabi Bagh", 2, "Green");
        metroGraph.addEdge("Punjabi Bagh", "Shivaji Park", 2, "Green");
        metroGraph.addEdge("Shivaji Park", "Madipur", 2, "Green");
        metroGraph.addEdge("Madipur", "Paschim Vihar East", 2, "Green");
        metroGraph.addEdge("Paschim Vihar East", "Paschim Vihar West", 2, "Green");
        metroGraph.addEdge("Paschim Vihar West", "Peera Garhi", 2, "Green");
        metroGraph.addEdge("Peera Garhi", "Udyog Nagar", 2, "Green");
        metroGraph.addEdge("Udyog Nagar", "Mundka", 2, "Green");
        metroGraph.addEdge("Mundka", "Mundka Industrial Area", 2, "Green");
        metroGraph.addEdge("Mundka Industrial Area", "Ghevra", 3, "Green");
        metroGraph.addEdge("Ghevra", "Tikri Kalan", 3, "Green");
        metroGraph.addEdge("Tikri Kalan", "Tikri Border", 2, "Green");
        metroGraph.addEdge("Tikri Border", "Brigadier Hoshiar Singh", 3, "Green");

        // Magenta Line (Botanical Garden to Janakpuri West)
        metroGraph.addEdge("Botanical Garden", "Okhla Bird Sanctuary", 3, "magenta");
        metroGraph.addEdge("Okhla Bird Sanctuary", "Kalindi Kunj", 3, "magenta");
        metroGraph.addEdge("Kalindi Kunj", "Jasola Vihar Shaheen Bagh", 3, "magenta");
        metroGraph.addEdge("Jasola Vihar Shaheen Bagh", "Okhla Vihar", 3, "magenta");
        metroGraph.addEdge("Okhla Vihar", "Jamia Millia Islamia", 3, "magenta");
        metroGraph.addEdge("Jamia Millia Islamia", "Sukhdev Vihar", 3, "magenta");
        metroGraph.addEdge("Sukhdev Vihar", "NSIC Okhla", 3, "magenta");
        metroGraph.addEdge("NSIC Okhla", "Nehru Enclave", 3, "magenta");
        metroGraph.addEdge("Nehru Enclave", "Greater Kailash", 3, "magenta");
        metroGraph.addEdge("Greater Kailash", "Chirag Delhi", 3, "magenta");
        metroGraph.addEdge("Chirag Delhi", "Panchsheel Park", 3, "magenta");
        metroGraph.addEdge("Panchsheel Park", "Hauz Khas", 3, "magenta");
        metroGraph.addEdge("Hauz Khas", "IIT Delhi", 3, "magenta");
        metroGraph.addEdge("IIT Delhi", "R.K. Puram", 3, "magenta");
        metroGraph.addEdge("R.K. Puram", "Munirka", 3, "magenta");
        metroGraph.addEdge("Munirka", "Vasant Vihar", 3, "magenta");
        metroGraph.addEdge("Vasant Vihar", "Terminal 1 IGI Airport", 3, "magenta");
        metroGraph.addEdge("Terminal 1 IGI Airport", "Sadar Bazar", 3, "magenta");
        metroGraph.addEdge("Sadar Bazar", "Palam", 3, "magenta");
        metroGraph.addEdge("Palam", "Dashrathpuri", 3, "magenta");
        metroGraph.addEdge("Dashrathpuri", "Dabri Mor", 3, "magenta");
        metroGraph.addEdge("Dabri Mor", "Janakpuri West", 3, "magenta");

        // Pink Line (Majlis Park to Shiv Vihar)
        metroGraph.addEdge("Majlis Park", "Azadpur", 3, "pink");
        metroGraph.addEdge("Azadpur", "Shalimar Bagh", 3, "pink");
        metroGraph.addEdge("Shalimar Bagh", "Netaji Subhash Place", 3, "pink");
        metroGraph.addEdge("Netaji Subhash Place", "Shakurpur", 3, "pink");
        metroGraph.addEdge("Shakurpur", "Punjabi Bagh West", 3, "pink");
        metroGraph.addEdge("Punjabi Bagh West", "ESI Hospital", 3, "pink");
        metroGraph.addEdge("ESI Hospital", "Rajouri Garden", 3, "pink");
        metroGraph.addEdge("Rajouri Garden", "Maya Puri", 3, "pink");
        metroGraph.addEdge("Maya Puri", "Naraina Vihar", 3, "pink");
        metroGraph.addEdge("Naraina Vihar", "Delhi Cantt", 3, "pink");
        metroGraph.addEdge("Delhi Cantt", "Durgabai Deshmukh South Campus", 3, "pink");
        metroGraph.addEdge("Durgabai Deshmukh South Campus", "Sir Vishweshwaraiah Moti Bagh", 3, "pink");
        metroGraph.addEdge("Sir Vishweshwaraiah Moti Bagh", "Bhikaji Cama Place", 3, "pink");
        metroGraph.addEdge("Bhikaji Cama Place", "Sarojini Nagar", 3, "pink");
        metroGraph.addEdge("Sarojini Nagar", "INA", 3, "pink");
        metroGraph.addEdge("INA", "South Extension", 3, "pink");
        metroGraph.addEdge("South Extension", "Lajpat Nagar", 3, "pink");
        metroGraph.addEdge("Lajpat Nagar", "Vinobapuri", 3, "pink");
        metroGraph.addEdge("Vinobapuri", "Ashram", 3, "pink");
        metroGraph.addEdge("Ashram", "Hazrat Nizamuddin", 3, "pink");
        metroGraph.addEdge("Hazrat Nizamuddin", "Mayur Vihar Phase-1", 3, "pink");
        metroGraph.addEdge("Mayur Vihar Phase-1", "Mayur Vihar Pocket I", 3, "pink");
        metroGraph.addEdge("Mayur Vihar Pocket I", "Trilokpuri Sanjay Lake", 3, "pink");
        metroGraph.addEdge("Trilokpuri Sanjay Lake", "East Vinod Nagar", 3, "pink");
        metroGraph.addEdge("East Vinod Nagar", "Mandawali", 3, "pink");
        metroGraph.addEdge("Mandawali", "IP Extension", 3, "pink");
        metroGraph.addEdge("IP Extension", "Anand Vihar", 3, "pink");
        metroGraph.addEdge("Anand Vihar", "Karkarduma", 3, "pink");
        metroGraph.addEdge("Karkarduma", "Karkarduma Court", 3, "pink");
        metroGraph.addEdge("Karkarduma Court", "Krishna Nagar", 3, "pink");
        metroGraph.addEdge("Krishna Nagar", "East Azad Nagar", 3, "pink");
        metroGraph.addEdge("East Azad Nagar", "Welcome", 3, "pink");
        metroGraph.addEdge("Welcome", "Jafrabad", 3, "pink");
        metroGraph.addEdge("Jafrabad", "Maujpur", 3, "pink");
        metroGraph.addEdge("Maujpur", "Gokulpuri", 3, "pink");
        metroGraph.addEdge("Gokulpuri", "Johri Enclave", 3, "pink");
        metroGraph.addEdge("Johri Enclave", "Shiv Vihar", 3, "pink");

        // Violet Line (Kashmere Gate to Raja Nahar Singh)
        metroGraph.addEdge("Kashmere Gate", "Lal Quila", 3, "violet");
        metroGraph.addEdge("Lal Quila", "Jama Masjid", 3, "violet");
        metroGraph.addEdge("Jama Masjid", "Delhi Gate", 3, "violet");
        metroGraph.addEdge("Delhi Gate", "ITO", 3, "violet");
        metroGraph.addEdge("ITO", "Mandi House", 3, "violet");
        metroGraph.addEdge("Mandi House", "Janpath", 3, "violet");
        metroGraph.addEdge("Janpath", "Central Secretariat", 3, "violet");
        metroGraph.addEdge("Central Secretariat", "Khan Market", 3, "violet");
        metroGraph.addEdge("Khan Market", "JLN Stadium", 3, "violet");
        metroGraph.addEdge("JLN Stadium", "Jangpura", 3, "violet");
        metroGraph.addEdge("Jangpura", "Lajpat Nagar", 3, "violet");
        metroGraph.addEdge("Lajpat Nagar", "Moolchand", 3, "violet");
        metroGraph.addEdge("Moolchand", "Kailash Colony", 3, "violet");
        metroGraph.addEdge("Kailash Colony", "Nehru Place", 3, "violet");
        metroGraph.addEdge("Nehru Place", "Kalkaji Mandir", 3, "violet");
        metroGraph.addEdge("Kalkaji Mandir", "Govind Puri", 3, "violet");
        metroGraph.addEdge("Govind Puri", "Harkesh Nagar Okhla", 3, "violet");
        metroGraph.addEdge("Harkesh Nagar Okhla", "Jasola Apollo", 3, "violet");
        metroGraph.addEdge("Jasola Apollo", "Sarita Vihar", 3, "violet");
        metroGraph.addEdge("Sarita Vihar", "Mohan Estate", 3, "violet");
        metroGraph.addEdge("Mohan Estate", "Tughlakabad", 3, "violet");
        metroGraph.addEdge("Tughlakabad", "Badarpur", 3, "violet");
        metroGraph.addEdge("Badarpur", "Sarai", 3, "violet");
        metroGraph.addEdge("Sarai", "NHPC Chowk", 3, "violet");
        metroGraph.addEdge("NHPC Chowk", "Mewala Maharajpur", 3, "violet");
        metroGraph.addEdge("Mewala Maharajpur", "Sector 28", 3, "violet");
        metroGraph.addEdge("Sector 28", "Badkhal Mor", 3, "violet");
        metroGraph.addEdge("Badkhal Mor", "Faridabad Old", 3, "violet");
        metroGraph.addEdge("Faridabad Old", "Neelam Chowk Ajronda", 3, "violet");
        metroGraph.addEdge("Neelam Chowk Ajronda", "Bata Chowk", 3, "violet");
        metroGraph.addEdge("Bata Chowk", "Escorts Mujesar", 3, "violet");
        metroGraph.addEdge("Escorts Mujesar", "Raja Nahar Singh", 3, "violet");

        // Grey Line (Dwarka - Najafgarh)
        metroGraph.addEdge("Dwarka", "Nangli", 3, "grey");
        metroGraph.addEdge("Nangli", "Najafgarh", 3, "grey");

        // Orange Line (Airport Express Line)
        metroGraph.addEdge("New Delhi", "Shivaji Stadium", 3, "orange");
        metroGraph.addEdge("Shivaji Stadium", "Dhaula Kuan", 3, "orange");
        metroGraph.addEdge("Dhaula Kuan", "Delhi Aerocity", 3, "orange");
        metroGraph.addEdge("Delhi Aerocity", "IGI Airport", 3, "orange");
        metroGraph.addEdge("IGI Airport", "Dwarka Sector 21", 3, "orange");

        // Find and print the shortest path
        metroGraph.findShortestPath(source, destination);
    }
}