package petstore.model

import org.joda.time.DateTime

/**
  * Created by terry on 1/30/16.
  */

case class Address(street1 : String, street2 : Option[String] = None, city : String, state : String, zipCode : String, country : String)

case class Customer(firstName : String, lastName : String, phone : String, email : String, homeAddress : Address)

case class Item(name : String, description : String, unitCost : Float, category : String)

case class Category(key : String, name : String, description : String)

case class LineItem(itemName : String, unitCost : Float, quantity : Int, gift : Boolean)

case class Order(customerEmail : String, createdOn : DateTime, orderLines : Seq[LineItem], deliveryAddress : Address)

case class Cart(customerEmail : String, items : Seq[LineItem], createdOn : DateTime)
