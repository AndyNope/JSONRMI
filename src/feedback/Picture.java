/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback;

import java.io.Serializable;

/**
 *
 * @author Andy Nope
 */
public class Picture implements Serializable{

    private String Link, Likes, Height, Width;

    public Picture(String Link, String Likes, String Height, String Width) {
        this.Link = Link;
        this.Likes = Likes;
        this.Height = Height;
        this.Width = Width;
    }

    
    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String Likes) {
        this.Likes = Likes;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String Height) {
        this.Height = Height;
    }

    public String getWidth() {
        return Width;
    }

    public void setWidth(String Width) {
        this.Width = Width;
    }
    
}
