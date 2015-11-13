package serenity.issues.pets;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AddAPetToThePetStoreTest {

    @Steps
    PetStoreSteps petStore;

    @Test
    public void shouldBeAbleToAddPetsToAStore() {

        Pet fido = new Pet("available", "fido");

        petStore.when_i_add_the_pet_to_the_store(fido);
        petStore.the_pets_should_be_available();
       petStore.issue_step();
//        petStore.when_i_delete_the_pet();
//        petStore.the_pets_should_be_not_available();
    }
}
