package orm;

public class Main {
    public static void main(String[] args) {
        DataBaseService.connect();

        UserRepository userRepository = new UserRepository(DataBaseService.connection);

        User maks = new User(3, "Maks", "abc");

        userRepository.beginTransaction();

        userRepository.insert(maks);
        System.out.println(userRepository.findById((int) maks.getId()).toString());

        maks = new User("Aleks", "qwe");

        userRepository.update(maks);
        userRepository.delete(maks);

        userRepository.commitTransaction();

        DataBaseService.disconnect();

    }
}