package com.cooktime.services;

import com.cooktime.model.AVLTree;
import com.cooktime.model.BinaryTree;
import com.cooktime.model.EnterpriseJson;
import com.cooktime.model.RecipeJson;
import com.cooktime.model.SplayTree;
import com.cooktime.model.UserJson;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
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
        
    @GET
    @Path("/getMatchUsers/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMatchUsers(@PathParam("name") String name) throws JSONException, IOException {
        
        int size = name.length();
        
        return Response.ok(binaryTree.matches(name, size)).build();                              
                            
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
    
    @GET
    @Path("/getMyMenuList/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMyMenuList(@PathParam("email") String email) throws JSONException, IOException {
                                
        if (binaryTree.contains(email)) {
            
            return Response.ok(binaryTree.getUser(email).getMyMenuList()).build();                              
                                                
        }
        
        return Response.status(Response.Status.NOT_FOUND).build();
        
    }
        
    @POST
    @Path("/postMyMenuList/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMyMenuList(@QueryParam("email") String email,
                                   @QueryParam("newRecipe") String newRecipe)
                                   throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            UserJson.insertMyMenuList(email, newRecipe);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postBubbleSort/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postBubbleSort(@QueryParam("email") String email) throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            //JSONParser parser = new JSONParser();
            
            //Object object = parser.parse(myMenuList);

            //JSONArray myMenuListJson = (JSONArray) object;

            UserJson.insertBubbleSort(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postQuickSort/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postQuickSort(@QueryParam("email") String email) throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            //JSONParser parser = new JSONParser();
            
            //Object object = parser.parse(myMenuList);

            //JSONArray myMenuListJson = (JSONArray) object;

            UserJson.insertQuickSort(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postRadixSort/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postRadixSort(@QueryParam("email") String email) throws JSONException, IOException, ParseException {
              
        if (binaryTree.contains(email)) {
            
            //JSONParser parser = new JSONParser();
            
            //Object object = parser.parse(myMenuList);

            //JSONArray myMenuListJson = (JSONArray) object;

            UserJson.insertRadixSort(email);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getMyMenuList()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postFollowers/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postFollowers(@QueryParam("email") String email,
                                  @QueryParam("newFollower") String newFollower)
                                  throws JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {

            UserJson.insertFollowers(email, newFollower);
            
            return Response.status(Response.Status.CREATED).entity(binaryTree.getUser(email).getFollowers()).build();                          
                                              
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postFollowed/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postFollowed(@QueryParam("email") String email,
                                 @QueryParam("newFollowed") String newFollowed)
                                 throws JSONException, IOException, ParseException {
                               
        if (binaryTree.contains(email)) {

            UserJson.insertFollowed(email, newFollowed);
            
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
    
    @GET
    @Path("/getMatchRecipes/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMatchRecipes(@PathParam("name") String name) throws JSONException, IOException {
        
        int size = name.length();
        
        return Response.ok(avltree.matches(name, size)).build();                              
                            
    }
            
    /*
    // Revisar si se usa, sino se borra
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
        
    */
    
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
        
        String newPublication[] = publication.split("/");
        
        int day = Integer.parseInt(newPublication[0]);
        int month = Integer.parseInt(newPublication[1]);
        int year = Integer.parseInt(newPublication[2]);            
          
        if (!avltree.contains(name)) {
            
            RecipeJson.insert(name, author, type, newPortions, newDuration, time, newDifficulty,
                              dietTag, photo, ingredients, steps, newPrice, newCalification,
                              day, month, year);
                    
            return Response.status(Response.Status.CREATED).entity(avltree.getRecipe(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postCalification/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCalification(@QueryParam("name") String name,
                                     @QueryParam("calification") String calification)                               
                                     throws JSONException, IOException {
        
        int newCalification = Integer.parseInt(calification);       
          
        if (avltree.contains(name)) {
            
            RecipeJson.insertCalification(name, newCalification);
                    
            return Response.status(Response.Status.CREATED).entity(avltree.getRecipe(name)).build();                          
                                                
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
      
    }
    
    @POST
    @Path("/postCommentary/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCommentary(@QueryParam("name") String name,
                                   @QueryParam("commentary") String commentary)                               
                                   throws JSONException, IOException {        
          
        if (avltree.contains(name)) {
            
            RecipeJson.insertCommentary(name, commentary);
                    
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
    
    @GET
    @Path("/getMatchEnterprises/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMatchEnterprises(@PathParam("name") String name) throws JSONException, IOException {
        
        int size = name.length();
        
        return Response.ok(splayTree.matches(name, size)).build();                              
                            
    }
    
    @POST
    @Path("/postEnterprise/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEnterprise(@QueryParam("name") String name,
                                   @QueryParam("logo") String logo,
                                   @QueryParam("contact") String contact,
                                   @QueryParam("schedule") String schedule,
                                   @QueryParam("direction") String direction,
                                   @QueryParam("members") String members)
                                   throws JSONException, IOException,
                                   ParseException {
                                       
        if (!splayTree.contains(name)) {
            
            String newMembers[] = members.split(",");
            
            ArrayList<String> finalMembers = new ArrayList<String>();
            
            for (int i = 0; i < newMembers.length; i ++) {
                
                finalMembers.add(newMembers[i]);                
                
            }        
            
            EnterpriseJson.insert(name, logo, contact, schedule, direction, finalMembers);
            
            return Response.status(Response.Status.CREATED).entity(splayTree.getEnterprise(name)).build();                           
                                               
        }
        
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();                
      
    }

}
