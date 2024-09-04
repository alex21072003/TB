import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.InputStream;

public class ServiceBotImages implements ServiceBot {
    @Override
    public SendDocument createSendDocument(String idUser, String path) {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("data/" + path);


        try {
            SendDocument sendDocument = new SendDocument();
            sendDocument.setChatId(idUser);
            sendDocument.setDocument(new InputFile(resourceAsStream, path));
            return sendDocument;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException();
        }
    }
}

