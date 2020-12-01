package UniversityCup.src;

import java.util.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class Grid {
    public static void main(String[] args) {

        
        int r = 0;
        int c = 0;
        int numShapes =0;
        int numBlocks;
        Shape [] shapes = new Shape[10000];
        int countShapes = 0;
        JSONParser jsonParser = new JSONParser();
        int numPoints = 0;

        try{

            FileReader reader = new FileReader("shapes_file.json");
            Object obj = jsonParser.parse(reader);
 
            JSONObject s = (JSONObject) obj;
            //System.out.println(s);

            JSONArray sha = (JSONArray) s.get("shapes");
            Iterator<JSONObject> iterator = sha.iterator();

    

            while(iterator.hasNext()){
                JSONObject current = iterator.next();
                
                

                JSONArray rot = (JSONArray) current.get("orientations");
                Iterator<JSONObject> rotI = rot.iterator();


                
                Iterator<JSONArray> it0 = ((JSONArray)rotI.next().get("cells")).iterator();
                int countOr = 0;
                while(it0.hasNext()){
                    Iterator<Long> it2 = ((JSONArray)it0.next()).iterator();
                   
                    //System.out.println(or0[countOr][0] + " " + or0[countOr][1]);
                    countOr++;
                    

                }
               
                
                numPoints = countOr;


            }

            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try{

            FileReader reader = new FileReader("shapes_file.json");
            Object obj = jsonParser.parse(reader);
 
            JSONObject s = (JSONObject) obj;
            //System.out.println(s);

            JSONArray sha = (JSONArray) s.get("shapes");
            Iterator<JSONObject> iterator = sha.iterator();

    

            while(iterator.hasNext()){






                JSONObject current = iterator.next();
                int id = Integer.parseInt( current.get("shape_id") +"");
                int box = Integer.parseInt( current.get("bounding_box") + "");
                int cap = Integer.parseInt( current.get("capacity") + "");
                int [] [] or0 = new int [numPoints][2];
                int [] [] or1 = new int [numPoints][2];
                int [] [] or2 = new int [numPoints][2];
                int [] [] or3 = new int [numPoints][2];

                JSONArray rot = (JSONArray) current.get("orientations");
                Iterator<JSONObject> rotI = rot.iterator();


                
                Iterator<JSONArray> it0 = ((JSONArray)rotI.next().get("cells")).iterator();
                int countOr = 0;
                while(it0.hasNext()){
                    Iterator<Long> it2 = ((JSONArray)it0.next()).iterator();
                    or0[countOr][0] = Integer.parseInt(it2.next() + "");
                    or0[countOr][1] = Integer.parseInt(it2.next() + "");
                    //System.out.println(or0[countOr][0] + " " + or0[countOr][1]);
                    countOr++;
                    

                }
                Iterator<JSONArray> it1 = ((JSONArray)rotI.next().get("cells")).iterator();
                int countOr1 = 0;
                while(it1.hasNext()){
                    Iterator<Long> it2 = ((JSONArray)it1.next()).iterator();
                    or1[countOr1][0] = Integer.parseInt(it2.next() + "");
                    or1[countOr1][1] = Integer.parseInt(it2.next() + "");
                    //System.out.println(or0[countOr][0] + " " + or0[countOr][1]);
                    countOr1++;
                    

                }
                Iterator<JSONArray> it3 = ((JSONArray)rotI.next().get("cells")).iterator();
                int countOr2 = 0;
                while(it3.hasNext()){
                    Iterator<Long> it2 = ((JSONArray)it3.next()).iterator();
                    or2[countOr2][0] = Integer.parseInt(it2.next() + "");
                    or2[countOr2][1] = Integer.parseInt(it2.next() + "");
                    //System.out.println(or0[countOr][0] + " " + or0[countOr][1]);
                    countOr2++;
                    

                }
                Iterator<JSONArray> it4 = ((JSONArray)rotI.next().get("cells")).iterator();
                int countOr3 = 0;
                while(it4.hasNext()){
                    Iterator<Long> it2 = ((JSONArray)it4.next()).iterator();
                    or3[countOr3][0] = Integer.parseInt(it2.next() + "");
                    or3[countOr3][1] = Integer.parseInt(it2.next() + "");
                    //System.out.println(or0[countOr][0] + " " + or0[countOr][1]);
                    countOr3++;
                    

                }


                // String holder0 = (String) rotI.next().get("cells");
                // String [] s0 = holder0.substring(1, holder0.length() -1).split(",");
                // for(int i = 0; i < s0.length; i++){
                //     or0[i][0] = (int)s0[i].charAt(1);
                //     or0[i][1] = (int)s0[i].charAt(3);
                //     System.out.println(or0[i][0] + "    " +  or0[i][1]);
                // }



                
                shapes[countShapes] = new Shape(id, box, cap, or0, or1, or2, or3);
                countShapes++;
                //System.out.println(countShapes);

            }

            //sha.forEach( emp -> parseShapes( (JSONObject) sh ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        

       
        boolean [][] grid = new boolean[1][1];
        try {
            Scanner scFile = new Scanner(new File("grid_5.input"));
            String [] size = scFile.nextLine().split(",");
            r = Integer.parseInt(size[0]);
            c = Integer.parseInt(size[1]);
            grid = new boolean[r][c];

            numShapes = Integer.parseInt(scFile.nextLine());
           

            numBlocks = Integer.parseInt(scFile.nextLine());

            for(int i = 0; i < numShapes; i++){
                String [] line = scFile.nextLine().split(",");
                shapes[Integer.parseInt(line[0])-1].quant = Integer.parseInt(line[1]);
                

            }
            //System.out.println(scFile.nextLine());
            String[] blocks = scFile.nextLine().split("\\|");
            scFile.close();
            for(int j = 0; j< blocks.length; j++){
                
                //System.out.println(blocky);
                String [] block = blocks[j].split(",");
               // System.out.println(block[0] + " , " + block[1]);
                grid[Integer.parseInt(block[0])][Integer.parseInt(block[1])] = true;
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        // for(int k = 0; k < r; k++){
        //     for(int d = 0; d < c; d++){
        //         System.out.print(grid[k][d]);
            

        //     }
        //     System.out.println();
            

        // }

        for(int k = 0; k < r; k++){
            for(int d = 0; d < c; d++){
                if (! grid[k][d]){
                    for(int x = 0; x < numShapes; x++){
                        if (shapes[x].quant > 0){
                            Shape now = shapes[x];
                            int [][] temp0 = now.or0;
                            int [][] temp1 = now.or1;
                            int [][] temp2 = now.or2;
                            int [][] temp3 = now.or3;
                            boolean flag1 = true;
                            for(int y = 0; y < temp0.length; y++){
                                int tmpX = 0;
                                int tmpY = 0;

                                tmpX = temp0[y][0] + k;
                                tmpY = temp0[y][1] + d;

                                if(tmpX >= 0 && tmpX < r && tmpY >= 0 && tmpY < c){
                                    if (grid[tmpX][tmpY]){
                                        flag1 = false;
                                        break;
                                    }
                                    
                                   
                                } else{
                                    flag1 = false;
                                    break;
                                }

                            }
                            if(flag1){
                                String out = now.id + "|";
                                for(int y = 0; y < now.box; y++){
                                    int tX = temp0[y][0] + k;
                                    int tY = temp0[y][1] + d;

                                    out = out + tX + "," + tY + "|"; 
    
                                    grid[temp0[y][0] + k][temp0[y][1] + d] = true;
                                    
                                }  
                                System.out.println(out.substring(0, out.length()-1));  
                                now.quant--;
                                break;
                            }
                            flag1 = true;
                            for(int y = 0; y < temp1.length; y++){
                                int tmpX = 0;
                                int tmpY = 0;

                                tmpX = temp1[y][0] + k;
                                tmpY = temp1[y][1] + d;

                                if(tmpX >= 0 && tmpX < r && tmpY >= 0 && tmpY < c){
                                    if (grid[tmpX][tmpY]){
                                        flag1 = false;
                                        break;
                                    }
                                    
                                   
                                } else{
                                    flag1 = false;
                                    break;
                                }

                            }
                            if(flag1){
                                String out = now.id + "|";
                                for(int y = 0; y < now.box; y++){
                                    int tX = temp1[y][0] + k;
                                    int tY = temp1[y][1] + d;

                                    out = out + tX + "," + tY + "|"; 
    
                                    grid[temp1[y][0] + k][temp1[y][1] + d] = true;
                                    
                                }  
                                System.out.println(out.substring(0, out.length()-1));  
                                now.quant--;
                                break;
                            }
                            flag1 = true;
                            for(int y = 0; y < now.box; y++){
                                int tmpX = 0;
                                int tmpY = 0;

                                tmpX = temp2[y][0] + k;
                                tmpY = temp2[y][1] + d;

                                
                                if(tmpX >= 0 && tmpX < r && tmpY >= 0 && tmpY < c){
                                    if (grid[tmpX][tmpY]){
                                        flag1 = false;
                                        break;
                                    }
                                    
                                   
                                } else{
                                    flag1 = false;
                                    break;
                                }

                            }
                            if(flag1){
                                String out = now.id + "|";
                                for(int y = 0; y < now.box; y++){
                                    int tX = temp2[y][0] + k;
                                    int tY = temp2[y][1] + d;

                                    out = out + tX + "," + tY + "|"; 
    
                                    grid[temp2[y][0] + k][temp2[y][1] + d] = true;
                                    
                                }  
                                System.out.println(out.substring(0, out.length()-1));  
                                now.quant--;
                                break;
                            }
                            flag1 = true;
                            for(int y = 0; y < now.box; y++){
                                int tmpX = 0;
                                int tmpY = 0;

                                tmpX = temp3[y][0] + k;
                                tmpY = temp3[y][1] + d;

                                if(tmpX >= 0 && tmpX < r && tmpY >= 0 && tmpY < c){
                                    if (grid[tmpX][tmpY]){
                                        flag1 = false;
                                        break;
                                    }
                                    
                                   
                                } else{
                                    flag1 = false;
                                    break;
                                }

                            }
                            if(flag1){
                                String out = now.id + "|";
                                for(int y = 0; y < now.box; y++){
                                    int tX = temp3[y][0] + k;
                                    int tY = temp3[y][1] + d;

                                    out = out + tX + "," + tY + "|"; 
    
                                    grid[temp3[y][0] + k][temp3[y][1] + d] = true;
                                    
                                }  
                                System.out.println(out.substring(0, out.length()-1));  
                                now.quant--;
                                break;
                            }

                        }
            

                    }
                }
            

            }
            
            

        }

        
    }

    
}