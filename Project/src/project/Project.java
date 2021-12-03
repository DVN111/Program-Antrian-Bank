/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Link {
    
    public String nama;
    public int notel; // data item
    public Link next; // next link in list

    public Link(int d,String n) // constructor
    {
        notel = d;
        nama = n;
        
    }

    public void displayLink() // display this link
    {
        
        System.out.print("|"+"\t"+notel +"\t"+"|"+"\t"+nama+"\t"+"|");
        
    }
} // end class Link

class FirstLastList {

    private Link first; // ref to first item
    private Link last; // ref to last item

    public FirstLastList() // constructor
    {
        first = null; // no items on list yet
        last = null;
    }

    public boolean isEmpty() // true if no links
    {
        return first == null;
    }

    public void insertLast(int notel,String nama) // insert at end of list
    {
        Link newLink = new Link(notel,nama); // make new link
        if (isEmpty()) // if empty list,
        {
            first = newLink; // first --> newLink
        } else {
            last.next = newLink; // old last --> newLink
        }
        last = newLink; // newLink <-- last
    }

    public int deleteFirst() // delete first link
    { // (assumes non-empty list)
        int temp = first.notel;
        if (first.next == null) // if only one item
        {
            last = null; // null <-- last
        }
        first = first.next; // first --> old next
        return temp;
    }

    public void displayList() {
        Link current = first; // start at beginning
        while (current != null) // until end of list,
        {
            System.out.println("");
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        
    }
} // end class FirstLastList

class LinkQueue {

    private FirstLastList theList;

    public LinkQueue() // constructor
    {
        theList = new FirstLastList();
    } // make a 2-ended list

    public boolean isEmpty() // true if queue is empty
    {
        return theList.isEmpty();
    }

    public void insert(int j,String n) // insert, rear of queue
    {
        theList.insertLast(j,n);
    }

    public long remove() // remove, front of queue
    {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Daftar Antrian Pelanggan");
        theList.displayList();
    }
    public void exit(){
        return;
    }
} 

class LinkQueueApp {

    public static void main(String[] args) throws IOException {
        LinkQueue LQ = new LinkQueue();
        Scanner sc = new Scanner(System.in);
        while (true) // interact with user
        {
            System.out.println("");
            System.out.print("Enter first letter of ");
            System.out.print("\na. Masukkan pelanggan ke antrian"+
                    "\nb. Panggil antrian terdepan"+
                    "\nc. Tampilkan Daftar Antrian Pelanggan"+
                    "\nd. Keluar"+
                    "\nMasukkan huruf : ");
            char choice = getChar();
            switch (choice) {
                case 'a':
                    System.out.println("Menambah antrian :");
                    System.out.print("Masukkan no antrian : ");
                    int noAntri = sc.nextInt();
                    System.out.print("Masukkan nama : ");
                    String nama = sc.next();
                    LQ.insert(noAntri,nama);
                    System.out.println(nama+" berhasil dimasukkan ke antrian");
//                    LQ.displayQueue();
                    System.out.println("");
                    break;

                case 'b':
                    System.out.println("Orang pertama dipanggil");
                    LQ.remove();
                    LQ.displayQueue();
                    break;
                    
                case 'c':
                    LQ.displayQueue();
                    break;
                    
                case 'd':
                    LQ.exit();
                    

                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main()
//--------------------------------------------------------------

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
//-------------------------------------------------------------

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

}