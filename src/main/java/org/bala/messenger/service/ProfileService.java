package org.bala.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bala.messenger.database.DataBase;
import org.bala.messenger.model.Profile;

public class ProfileService {
      private static Map<String,Profile> profiles = DataBase.getProfiles();
      
      public List<Profile> getAllProfiles()
      {
    	  return  new ArrayList<>(profiles.values());
      }
      
      public Profile addProfile(Profile profile)
      {
    	  String profileName = profile.getProfileName();
    	  if(profileName == null || profiles.containsKey(profileName))
    		  return null;
    	  profiles.put(profileName, profile);
    	  return profile;
      }
      
      public Profile removeProfile(String profileName)
      {
    	  return profiles.remove(profileName);
      }
      
      public Profile updateProfile(Profile profile)
      {
    	String profileName = profile.getProfileName();
    	if(profileName==null || !profiles.containsKey(profileName))
    		return null;
    	profiles.put(profileName, profile);
    	return profile;
      }
      
      public Profile getProfile(String profileName)
      {
    	  return profiles.get(profileName);
      }
}
