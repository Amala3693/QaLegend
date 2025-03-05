package Utilities;

import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class Fakertility { //it is an inbuilt class to generate unique test data
	public static String getFakeFirstName()
	{
		Faker faker = new Faker();
		Address address = faker.address();
		String text = address.firstName();
		return text;
	}
	public static String getfakeLastName()
	{
		Faker faker = new Faker();
		Address address = faker.address();
		String text = address.lastName();
		return text;	
	}
	public static String getFakecityName()
	{
		Faker faker = new Faker();
		Address address = faker.address();
		String text = address.cityName();
		return text;
	}
	public static int getRandomNumber()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(1000000);
		return randomNumber;
	}

}
