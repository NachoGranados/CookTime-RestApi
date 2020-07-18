package com.cooktime.services;

import com.cooktime.model.AVLTree;
import com.cooktime.model.BinaryTree;
import com.cooktime.model.EnterpriseJson;
import com.cooktime.model.RecipeJson;
import com.cooktime.model.SplayTree;
import com.cooktime.model.UserJson;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("services")
public class Services {
    
    private BinaryTree binaryTree = UserJson.getBinaryTree();
    private AVLTree avltree = RecipeJson.getAVLTree();
    private SplayTree splayTree = EnterpriseJson.getSplayTree();
    
    @GET
    @Path("/getAllUsers/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() throws JSONException, IOException {
                                
        return Response.ok(binaryTree.inOrder()).build();
        
    }    
    
    @GET
    @Path("/getUser/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("email") String email) throws JSONException, IOException {
                                
        if (binaryTree.contains(email)) {
            
            return Response.ok(binaryTree.getUser(email)).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
        
    @POST
    @Path("/postUser/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUser(@QueryParam("email") String email,
                             @QueryParam("name") String name,
                             @QueryParam("lastName") String lastName,
                             @QueryParam("age") String age,
                             @QueryParam("password") String password,
                             @QueryParam("photo") String photo,
                             @QueryParam("chef") boolean chef) throws
                             JSONException, IOException, ParseException {
        
        int newAge = Integer.parseInt(age);
                               
        if (!binaryTree.contains(email)) {               
                        
            UserJson.insert(email, name, lastName, newAge, password, photo, chef);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }  
        
    @POST
    @Path("/postChef/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postChef(@QueryParam("email") String email) throws
                             JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {   
            
            UserJson.insertChef(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email)).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    } 
    
    @POST
    @Path("/postMyMenuList/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMyMenuList(@QueryParam("email") String email,
                                   @QueryParam("myMenuList") String myMenuList)
                                   throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            JSONParser parser = new JSONParser();
            
            Object object = parser.parse(myMenuList);

            JSONArray myMenuListJson = (JSONArray) object;

            UserJson.insertMyMenuList(email, myMenuListJson);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postBubbleSort/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postBubbleSort(@QueryParam("email") String email,
                                   @QueryParam("myMenuList") String myMenuList)
                                   throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            JSONParser parser = new JSONParser();
            
            Object object = parser.parse(myMenuList);

            JSONArray myMenuListJson = (JSONArray) object;

            UserJson.insertMyMenuList(email, myMenuListJson);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postQuickSort/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postQuickSort(@QueryParam("email") String email,
                                   @QueryParam("myMenuList") String myMenuList)
                                   throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            JSONParser parser = new JSONParser();
            
            Object object = parser.parse(myMenuList);

            JSONArray myMenuListJson = (JSONArray) object;

            UserJson.insertMyMenuList(email, myMenuListJson);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postRadixSort/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRadixSort(@QueryParam("email") String email,
                                   @QueryParam("myMenuList") String myMenuList)
                                   throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            JSONParser parser = new JSONParser();
            
            Object object = parser.parse(myMenuList);

            JSONArray myMenuListJson = (JSONArray) object;

            UserJson.insertMyMenuList(email, myMenuListJson);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postFollowers/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postFollowers(@QueryParam("email") String email,
                                  @QueryParam("followers") String followers)
                                  throws JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {
            
            JSONParser parser = new JSONParser();
            
            Object object = parser.parse(followers);

            JSONArray followersJson = (JSONArray) object;

            UserJson.insertFollowers(email, followersJson);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getFollowers()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postFollowed/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postFollowed(@QueryParam("email") String email,
                                 @QueryParam("followed") String followed)
                                 throws JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {
            
            JSONParser parser = new JSONParser();
            
            Object object = parser.parse(followed);

            JSONArray followedJson = (JSONArray) object;

            UserJson.insertFollowed(email, followedJson);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getFollowed()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @GET
    @Path("/getAllRecipes/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRecipes() throws JSONException, IOException {
                                
        return Response.ok(avltree.inOrder()).build();
        
    } 
      
    @GET
    @Path("/getRecipe/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipe(@PathParam("name") String name) throws JSONException, IOException {
                                
        if (avltree.contains(name)) {
            
            return Response.ok(avltree.getRecipe(name)).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
    
    @DELETE
    @Path("/deleteRecipe/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRecipe(@PathParam("name") String name) throws JSONException, IOException {
        
        if (avltree.contains(name)) {
            
            avltree.remove(name);
            
            return Response.ok().build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
        
    @POST
    @Path("/postRecipe/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRecipe(@QueryParam("name") String name,
                               @QueryParam("author") String author,
                               @QueryParam("type") String type,
                               @QueryParam("portions") String portions,
                               @QueryParam("duration") String duration,
                               @QueryParam("time") String time,
                               @QueryParam("difficulty") String difficulty,
                               @QueryParam("dietTag") String dietTag,
                               @QueryParam("photo") String photo,
                               @QueryParam("ingredients") String ingredients,
                               @QueryParam("steps") String steps,
                               @QueryParam("price") String price,
                               @QueryParam("calification") String calification,
                               @QueryParam("publication") String publication)                               
                               throws JSONException, IOException {
        
        int newPortions = Integer.parseInt(portions);
        int newDuration = Integer.parseInt(duration);
        int newDifficulty = Integer.parseInt(difficulty);
        int newPrice = Integer.parseInt(price);
        int newCalification = Integer.parseInt(calification);
        int newPublication = Integer.parseInt(publication);
        
          
        if (!avltree.contains(name)) {
            
            RecipeJson.insert(name, author, type, newPortions, newDuration, time, newDifficulty,
                              dietTag, photo, ingredients, steps, newPrice, newCalification,
                              newPublication);
                    
            return Response.status(Response.Status.CREATED).entity(avltree.getRecipe(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
 
    @GET
    @Path("/getAllEnterprises/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEnterprises() throws JSONException, IOException {
                                
        return Response.ok(splayTree.inOrder()).build();
        
    } 
    
    @GET
    @Path("/getEnterprise/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnterprise(@PathParam("name") String name) throws JSONException, IOException {
                                
        if (splayTree.contains(name)) {
            
            return Response.ok(splayTree.getEnterprise(name)).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
    
    @POST
    @Path("/postEnterprise/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEnterprise(@QueryParam("name") String name,
                                   @QueryParam("logo") String logo,
                                   @QueryParam("contact") String contact,
                                   @QueryParam("schedule") String schedule,
                                   @QueryParam("direction") String direction)
                                   throws JSONException, IOException {
                               
        if (!splayTree.contains(name)) {
            
            EnterpriseJson.insert(name, logo, contact, schedule, direction);
            
            return Response.status(Response.Status.CREATED).entity(splayTree.getEnterprise(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }     

    @POST    
    @Path("/postPrueba/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(@QueryParam("list") String list) throws ParseException {
        
        
        JSONParser parser = new JSONParser();
        
        JSONObject json = (JSONObject) parser.parse(list);
        
        JSONArray jSONArray = (JSONArray) json.get("list");

        return Response.status(Response.Status.CREATED).entity(jSONArray).build();
      
    }  
        
}
