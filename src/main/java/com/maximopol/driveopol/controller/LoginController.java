package com.maximopol.driveopol.controller;

//import com.maximopol.driveopol.service.LoginService;


//@Controller
//@SessionAttributes("name")
//public class LoginController {
//    @Autowired
//    LoginService service;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private AuthProvider authProvider;
//
//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String showLoginPage(ModelMap model){
//        System.out.println("rewrwerwer");
//        return "login";
//    }
//
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public String showWelcomePage(HttpServletRequest request,ModelMap model, @RequestParam String name, @RequestParam String password){
//        System.out.println("hjhjkjjjjjjjjjjjjjjjjjjjj");
//
//        System.out.println(name+":"+password);
//
//        if (!service.validateUser(name, password)) {
//            model.put("errorMessage", "Invalid Credentials");
//            return "login";
//        }
//      //  authProvider.authenticate();
////        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(name, password);
////        authToken.setDetails(new WebAuthenticationDetails(request));
////
////        Authentication authentication = authenticationManager.authenticate(authToken);
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//
////        model.put("name", name);
////        model.put("password", password);
////
////        userService.loadUserByUsername(name);
//
//        return "welcome";
//    }
//}
