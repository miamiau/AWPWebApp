/// **
// *
// */
// package com.awp.it;
//
// import java.util.ArrayList;
//
// import javax.ws.rs.client.Client;
// import javax.ws.rs.client.ClientBuilder;
// import javax.ws.rs.client.Entity;
// import javax.ws.rs.client.WebTarget;
// import javax.ws.rs.core.GenericType;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response;
//
// import com.awp.model.Room;
//
// import junit.framework.Assert;
//
/// **
// * @author teodora.cosma
// *
// */
// public class RoomIT {
// private static final String rootURI = "http://localhost:8080/restjug/rest";
//
// private Room addRoom(Room room) {
// Client client = ClientBuilder.newClient();
//
// WebTarget target = client.target(rootURI + "/rooms");
//
// Response response = target.request().post(Entity.entity(room,
/// MediaType.APPLICATION_JSON));
// Room updated = response.readEntity(Room.class);
//
// response.close();
//
// Assert.assertEquals(Response.Status.CREATED.getStatusCode(),
/// response.getStatus());
//
// return updated;
// }
//
// private Room updateRoom(Room room) {
// Client client = ClientBuilder.newClient();
// WebTarget target = client.target(room.getHref());
//
// Response response = target.request(MediaType.APPLICATION_JSON)
// .put(Entity.entity(room, MediaType.APPLICATION_JSON));
// Room updated = response.readEntity(Room.class);
//
// response.close();
//
// Assert.assertEquals(Response.Status.OK.getStatusCode(),
/// response.getStatus());
//
// return updated;
// }
//
// private void resetRepo() {
// Client client = ClientBuilder.newClient();
// WebTarget target = client.target(rootURI + "/rooms/default");
//
// Response response = target.request(MediaType.APPLICATION_JSON).get();
// Assert.assertEquals(Response.Status.OK.getStatusCode(),
/// response.getStatus());
//
// response.close();
// }
//
// private void checkInitialRepo() {
// Client client = ClientBuilder.newClient();
// WebTarget target = client.target(rootURI + "/rooms/");
//
// Response response = target.request(MediaType.APPLICATION_JSON).get();
// Assert.assertEquals(Response.Status.OK.getStatusCode(),
/// response.getStatus());
//
// ArrayList<Room> rooms = response.readEntity(new
/// GenericType<ArrayList<Room>>() {
// });
// Assert.assertEquals(2, rooms.size());
//
// // We may test here also the content of the airplanes.
//
// response.close();
// }
//
// }
