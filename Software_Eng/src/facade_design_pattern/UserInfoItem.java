package facade_design_pattern;

public interface UserInfoItem {

	public String getName();

	public UserInfoItem getCurrentUser();

	public String getUserId();

	public String getPassword();

	public UserType getUserType();

}
