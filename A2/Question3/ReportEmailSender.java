import java.util.ArrayList;

public class ReportEmailSender {
    public static void sendToEmail(ArrayList<String> reportData, String emailAddress) {
        try {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < reportData.size(); i++) {
                builder.append(reportData.get(i) + "\n");
            }
            EmailSender sender = new EmailSender();
            sender.sendEmail(emailAddress, "Profit Report!", builder.toString());
        } catch (Exception e) {
            System.out.println("Yipes internet must be down!");
        }
    }
}