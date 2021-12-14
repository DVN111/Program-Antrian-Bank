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
    public String alamat;
    public int no_antrian; 
    public Link next; 

    public Link(int d,String n,String a) // constructor
    {
        no_antrian = d;
        nama = n;
        alamat = a;
        
    }

    public void displayLink() // display this link
    {
        System.out.println("|"+"   "+no_antrian+"   "+"|"+"\t"+nama+"\t"+"   |"+"\t"+       alamat+"\t"+"|");
    }
} 

class List {

    private Link first; // ref ke item pertama
    private Link last; // ref to item terakhir

    public List() // constructor
    {
        first = null; // no items on list yet
        last = null;
    }

    public boolean isEmpty() // true if no links
    {
        return first == null;
    }

    public void insertLast(int noantrian,String nama,String alamat) // insert di akhir
    {
        Link newLink = new Link(noantrian,nama,alamat); // membuat link baru
        if (isEmpty()) //misal kosong
        {
            first = newLink; // first --> newLink 
        } else {
           
            last.next = newLink; // old last --> newLink
            
        }
        last = newLink; // newLink <-- last
        System.out.println(nama+" berhasil dimasukkan ke antrian");
    }

    public int deleteFirst() 
    {
        int temp = first.no_antrian;
        if (first.next == null) 
        {
            last = null; 
        }
        first = first.next; 
        return temp;
    }

    public void displayList() {
        Link current = first; 
        while (current != null) 
        {

            current.displayLink(); 
            current = current.next; 
        }   
    }
    
     public boolean search(String x)
    {
        Link current = first;    //Initialize current

        while (current != null)
        {
            if (current.nama.equals(x)){
                System.out.println(x+" ditemukan");
                current.displayLink();
                return true;    //data found
                 
            }
            current = current.next; 
        }
        return false;    //data not found
    }
     
} 
class LinkQueue {

    private List theList;
    private int no = 1;
    
    public LinkQueue() 
    {
        theList = new List();
    } 

    public boolean isEmpty() 
    {
        return theList.isEmpty();
    }

    public void insert(String n,String a) 
    {
        theList.insertLast(no,n,a);
        no = no+1;
    }

    public long remove() 
    {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.println("Daftar Antrian Pelanggan");
        System.out.println("+-------+------------------+--------------------+");
        System.out.println("|"+" "+"Nomor"+" "+"|"+"\t"+"Nama"+"\t"+"   |"+"\t"+"   Alamat"+"\t"+"|");
        System.out.println("+-------+------------------+--------------------+");
        theList.displayList();
        System.out.println("+-------+------------------+--------------------+");
    }
    
    public void search(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("masukkan nama yang ingin dicari = ");
        String nama = sc.next();
        System.out.println("");
        theList.search(nama);
    }
    
    public void resetQueueNum(){
        no=1;
    }
} 

class LinkQueueApp {

    public static void main(String[] args) throws IOException {
        LinkQueue LQ = new LinkQueue();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Selamat datang di program Antrian BANK");
        while (true) // interact with user
        {
            System.out.println("");
            
            System.out.print("= Menu pilihan =");
            System.out.print("\na. Masukkan nasabah ke antrian"+
                    "\nb. Panggil nasabah antrian terdepan"+
                    "\nc. Tampilkan Daftar Antrian Nasabah"+
                    "\n-. Reset Nomor Antrian"+
                    "\n?. Cek Nasabah Yang Mengantri Berdasarkan nama"+
                    "\nx. Keluar"+
                    "\nMasukkan huruf : ");
            char choice = getChar();
            switch (choice) {
                case 'a':
                    System.out.println("Menambah antrian :");
                    System.out.print("Masukkan nama : ");
                    String nama = sc.next();
                    System.out.print("Masukkan alamat : ");
                    String alamat = sc.next();
                    LQ.insert(nama,alamat);
                    System.out.println("");
                    break;

                case 'b':
                    System.out.println("");
                    System.out.println("Antrian terdepan dipanggil");
                    LQ.remove();
                    LQ.displayQueue();
                    System.out.println("");
                    break;
                    
                case 'c':
                    System.out.println("");
                    LQ.displayQueue();
                    System.out.println("");
                    break;
                    
                 case'-':
                     LQ.resetQueueNum();
                     break;
                    case'?':
                        
                        LQ.search();
                        System.out.println("");
                        break;
                case 'x':
                    return;
                    

                default:
                    System.out.print("Invalid entry\n");
            } 
        } 
    } 

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

}