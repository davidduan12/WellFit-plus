package entity;

public interface User {
    /** Gets the name of the user*/
    String getName();

    /** Returns the password of the user*/
    String getPassword();

    /** Returns the weight of the user, in Kilograms(KG) */
    float getWeight();

    /** Returns the height of the user, in Meters (M)*/
    int getHeight();

    /** Returns the BMI of the user, calculated by weight(KG) / height(M)^2 */
    float getBMI();

}
