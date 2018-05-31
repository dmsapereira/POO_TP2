import java.util.*;

import Exceptions.*;
import Media.*;
import User.Account;
import User.Device;
import User.Plan;

public interface Streaming {

    /**
     * Registers a new <code>Account</code>
     *
     * @param name     <code>Account</code>'s name
     * @param email    <code>Account</code>'e email
     * @param password <code>Account</code>'s password
     * @param device   <code>Account</code>'s first log in <code>Device</code>
     * @throws OtherAccountLoggedInException when there's another <code>Account</code> already logged in
     * @throws DuplicateEmailException       when there's an <code>Account</code> using the same email
     */
    void register(String name, String email, String password, String device) throws OtherAccountLoggedInException, DuplicateEmailException;

    /**
     * Logs into another <code>Account</code>
     *
     * @param email    <code>Account</code>'s email
     * @param password <code>Account</code>'s password
     * @param device   <code>Device</code> of the login
     * @throws AccountLoggedInException      when the <code>Account</code> with the inserted credentials is already logged in
     * @throws DeviceCapacityException       when there's a login with a new <code>Device</code> that would exceed the <code>Account</code>'s <code>Plan</code>'s maximum devices
     * @throws NullAccountException          when the inserted credentials do not belong to any <code>Account</code>
     * @throws OtherAccountLoggedInException when there's another <code>Account</code> already logged in
     * @throws WrongPasswordException        when the inserted password does not match the <code>Account</code>'s password
     */
    void login(String email, String password, String device) throws AccountLoggedInException, DeviceCapacityException, NullAccountException, OtherAccountLoggedInException, WrongPasswordException;

    /**
     * Uploads a new <code>Movie</code>
     *
     * @param name         <code>Movie</code>'s name
     * @param directorName <code>Movie</code>'s director's name
     * @param duration     <code>Movie</code>'s duration
     * @param ageRating    <code>Movie</code>'s age rating
     * @param debutDate    <code>Movie</code>'s debut date
     * @param genre        <code>Movie</code>'s genre
     * @param cast         <code>Movie</code>'s cast, in form of a <code>Set</code> containing <code>String</code>s
     */
    void uploadMovie(String name, String directorName, int duration, int ageRating, int debutDate, String genre, LinkedList<String> cast);

    /**
     * Uploads a new <code>Show</code>
     *
     * @param name         <code>Show</code>'s name
     * @param directorName <code>Show</code>'s director's name
     * @param numSeasons   <code>Show</code>'s number of seasons
     * @param numEpisodes  <code>Show</code>'s number of episodes per season
     * @param ageRating    <code>Show</code>'s age rating
     * @param debutDate    <code>Show</code>'s debut date
     * @param genre        <code>Show</code>'s genre
     * @param cast         <code>Show</code>'s cast, in form of a <code>Set</code> containing <code>String</code>s
     */
    void uploadShow(String name, String directorName, int numSeasons, int numEpisodes, int ageRating, int debutDate, String genre, LinkedList<String> cast);

    /**
     * Disconnects the current <code>Account</code>, leaving the <code>Device</code> active
     *
     * @return current <code>Account</code>'s <code>Device</code>
     * @throws NullLoggedAccountException when there's no logged <code>Account</code>
     */
    Device disconnect() throws NullLoggedAccountException;

    /**
     * Logs out of the current <code>Account</code>, terminating the <code>Device</code>'s connection
     *
     * @return current <code>Account</code>'s <code>Device</code>
     * @throws NullLoggedAccountException when there's no logged <code>Account</code>
     */
    Device logout() throws NullLoggedAccountException;

    /**
     * Returns the logged in <code>Account</code>
     *
     * @return logged <code>Account</code>
     * @throws NullLoggedAccountException when there's no <code>Account</code> logged in
     */
    Account getLoggedAccount() throws NullLoggedAccountException;

    /**
     * Changes the current <code>Account</code>'s <code>Plan</code>
     *
     * @param newplan new <code>Plan</code> to be applied to the current <code>Account</code>
     * @throws NullLoggedAccountException      when there's no <code>Account</code> logged in
     * @throws DuplicatePlanException          when the <code>newPlan</code> is the same as the current <code>Account</code>'s <code>Plan</code>
     * @throws PlanLimitationOverflowException when the <code>Account</code>'s number of <code>Device</code>s or <code>Profile</code>s is not compatible with the <code>newPlan</code>
     */
    void changePlan(Plan newplan) throws NullLoggedAccountException, DuplicatePlanException, PlanLimitationOverflowException;

    /**
     * Returns an <code>Iterator</code> for the <code>Media</code> database
     *
     * @return <code>Iterator</code> for the registered <code>Media</code>
     */
    Iterator<Media> getMedia();

    /**
     * Returns an <code>Account</code> with the corresponding <code>email</code>
     *
     * @param email <code>Account</code>'s email
     * @return <code>Account</code> with the corresponding email. <code>null</code> if none were found
     */
    Account getAccount(String email);

    /**
     * Registers a new <code>StandardProfile</code>
     *
     * @param name new <code>StandardProfile</code>'s name
     * @throws NullLoggedAccountException         when there's no <code>Account</code> logged in
     * @throws DuplicateProfileException          when there's an existing <code>Profile</code> with <code>name</code>
     * @throws ProfileLimitationOverflowException when there's too many <code>Profile</code>s for the current <code>Account</code>'s <code>Plan</code>
     */
    void addStandardProfile(String name) throws NullLoggedAccountException, DuplicateProfileException, ProfileLimitationOverflowException;

    /**
     * Registers a new <code>KidProfile</code>
     *
     * @param name      new <code>KidProfile</code>'s name
     * @param ageRating new <code>KidProfile</code>'s age rating
     * @throws NullLoggedAccountException         when there's no <code>Account</code> logged in
     * @throws DuplicateProfileException          when there's an existing <code>Profile</code> with <code>name</code>
     * @throws ProfileLimitationOverflowException when there's too many <code>Profile</code>s for the current <code>Account</code>'s <code>Plan</code>
     */
    void addChildProfile(String name, int ageRating) throws NullLoggedAccountException, DuplicateProfileException, ProfileLimitationOverflowException;

    /**
     * Selects a <code>Profile</code>
     *
     * @param name <code>Profile</code>'s name
     * @throws NullProfileException       when there's no <code>Profile</code> with <code>name</code>
     * @throws NullLoggedAccountException when there's no <code>Account</code> logged in
     */
    void selectProfile(String name) throws NullProfileException, NullLoggedAccountException;

    /**
     * Watches a <code>Media</code>
     *
     * @param media <code>Media</code>'s name
     * @throws NullLoggedAccountException when there's no <code>Account</code> logged in
     * @throws NullLoggedProfileException when there's no <code>Profile</code> selected
     * @throws NullMediaException         when there's no <code>Media</code> with the name <code>media</code>
     * @throws AgeRatingMismatchException when the found <code>Media</code>'s rating is greater than the current <code>Profile</code>'s
     */
    void watch(String media) throws NullLoggedAccountException, NullLoggedProfileException, NullMediaException, AgeRatingMismatchException;

    /**
     * Rates a <code>Media</code>
     *
     * @param media  <code>Media</code>'s name
     * @param rating <code>Media</code>'s rating
     * @throws NullLoggedAccountException   when there's no <code>Account</code> logged in
     * @throws NullLoggedProfileException   when there's no <code>Profile</code> selected
     * @throws NullMediaException           when there's no <code>Media</code> with the name <code>media</code>
     * @throws NullWatchedMediaException    when the <code>Profile</code> hasn't watched anything yet
     * @throws DuplicateRatedMediaException when the found <code>Media</code> has already been rated
     */
    void rate(String media, int rating) throws NullLoggedAccountException, NullLoggedProfileException, NullMediaException, NullWatchedMediaException, DuplicateRatedMediaException;

    /**
     * Returns an <code>Iterator</code> for a <code>Set</code> of <code>Media</code> with the genre <code>genre</code>
     * @param genre genre to filter <code>Media</code> for
     * @return <code>Iterator</code> for a list of <code>Media</code> with the genre <code>genre</code>, sorted by title
     * @throws NullLoggedAccountException   when there's no <code>Account</code> logged in
     * @throws NullLoggedProfileException   when there's no <code>Profile</code> selected
     * @throws MediaIterationException      when there were no <code>Media</code> found with that genre
     */
    Iterator<Media> searchByGenre(String genre) throws NullLoggedAccountException, NullLoggedProfileException, MediaIterationException;

    /**
     * Returns an <code>Iterator</code> for a <code>Set</code> of <code>Media</code> whose cast contains the member <code>name</code>
     * @param name cast member's name to look for
     * @return <code>Iterator</code> for a list of <code>Media</code> with the cast member, or director, <code>name</code>, sorted by insertion order
     * @throws NullLoggedAccountException   when there's no <code>Account</code> logged in
     * @throws NullLoggedProfileException   when there's no <code>Profile</code> selected
     * @throws MediaIterationException      when there were no <code>Media</code> found with the member <code>name</code>
     */
    Iterator<Media> searchByName(String name) throws NullLoggedAccountException, NullLoggedProfileException, MediaIterationException;

    /**
     * Returns an <code>Iterator</code> for a <code>Set</code> of <code>Rated</code> <code>Media</code>, whose rating is greater than or equal to <code>rating</code> and whose rating has been averaged with all the <code>Account</code>s, sorted by rating
     * @param rating rating to filter the <code>Media</code> for
     * @return <code>Iterator</code> for a list of filtered <code>Rated</code> <code>Media</code>, sorted by rating
     * @throws NullLoggedAccountException   when there's no <code>Account</code> logged in
     * @throws NullLoggedProfileException   when there's no <code>Profile</code> selected
     * @throws MediaIterationException      when there were no <code>Media</code> found with specified rating requirements
     */
    Iterator<Rated> searchByRating(int rating) throws NullLoggedAccountException, NullLoggedProfileException, MediaIterationException;
}