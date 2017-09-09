package kr.co.starrysky;

import com.google.gson.Gson;

import java.util.logging.Logger;

import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import kr.co.starrysky.models.KakaoAddFriendModel;
import kr.co.starrysky.models.KakaoKeyboardModel;
import kr.co.starrysky.models.KakaoMessageModel;
import kr.co.starrysky.models.KakaoRequestMessageModel;
import kr.co.starrysky.models.SlackModel;

import static javax.ws.rs.core.Response.Status.OK;

@Path(Constants.API_KAKAO)
public class JavaRESTKakaoTalk {
    private static final Logger log = Logger.getLogger(JavaRESTKakaoTalk.class.getName());


    @GET
    @Path("keyboard")
    @Produces(MediaType.APPLICATION_JSON)
    public final Response getKeyboard() {
        KakaoKeyboardModel keyboardModel = new KakaoKeyboardModel.Builder().createTextModel();
        return Response.status(OK).encoding("utf-8").entity(new Gson().toJson(keyboardModel)).build();
    }

    @POST
    @Encoded
    @Path("message")
    @Produces(MediaType.APPLICATION_JSON)
    public final Response getMessage(KakaoRequestMessageModel requestMessageModel) {
        StringBuilder tempMessage = new StringBuilder();
        tempMessage.append(requestMessageModel.getUser_key());
        tempMessage.append(" : (").append(requestMessageModel.getType()).append(")");
        tempMessage.append(" - ").append(requestMessageModel.getContent());

        new SlackModel().sendNotification(tempMessage.toString());
        KakaoMessageModel messageModel = new KakaoMessageModel(tempMessage.toString());
        return Response.status(OK).entity(new Gson().toJson(messageModel)).build();
    }


    @POST
    @Path("friend")
    @Produces(MediaType.APPLICATION_JSON)
    public final Response addFriend(KakaoAddFriendModel addFriendModel) {
        new SlackModel().sendNotification("add Friend - " + addFriendModel.getUser_key());
        return Response.status(OK).entity("").build();
    }


    @DELETE
    @Path("friend/{user_key}")
    @Produces(MediaType.APPLICATION_JSON)
    public final Response deleteFriend(@PathParam(value = "user_key") String user_key) {
        new SlackModel().sendNotification("remove Friend - " + user_key);
        return Response.status(OK).entity("").build();
    }


    @DELETE
    @Path("chat_room/{user_key}")
    @Produces(MediaType.APPLICATION_JSON)
    public final Response exitChatRoom(@PathParam(value = "user_key") String user_key) {
        new SlackModel().sendNotification("exit chat - " + user_key);
        return Response.status(OK).entity("").build();
    }
}
