package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청을 처리한다는 것을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 인식한다. 
public class ContactController {
  // add와 list는 
  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String[size]; 
    for(int i=0; i<size; i++) {
      arr[i] = contacts[i]; 
    }
    return arr; 
  }
  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    contacts[size++] = createCSV(name, email, tel, company);
    return size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    for (int i = 0; i < size; i++) { //size : 배열에 입력된 개수



      if (contacts[i].split(",")[1].equals(email)) { 
        return contacts[i];
      }
    }
    return "";
  }
  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 
        contacts[i] = createCSV(name, email, tel, company);
        return 1;
      }
    }
    return 0;
  }
  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 

        for (int j = i + 1; j < size; j++) {
          contacts[j - 1] = contacts[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }

  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }
}


