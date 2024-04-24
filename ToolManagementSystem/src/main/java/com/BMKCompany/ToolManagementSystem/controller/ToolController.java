package com.BMKCompany.ToolManagementSystem.controller;

@RestController
@RequestMapping("/tool")
public class ToolController {

    @Autowired
    private ToolRepo toolRepo;


    //retrieve tools data from database
    @GetMapping("/gettools")
    public List<Tool> getTools() {
        return toolRepo.findAll();
    }


    //get tools details from toolid
    @GetMapping("/gettool/{toolId}")
    public ResponseEntity<Tool> getToolById(@PathVariable("toolId") String toolId){
        Optional<Tool> tool = toolRepo.findById(toolId);
        return tool.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Check toolId already exists in the system
    @GetMapping("/check/{toolId}")
    public ResponseEntity<Map<String,Boolean>> checkToolIdExists(@PathVariable String toolId){
        boolean exists = toolRepo.existsById(toolId);
        Map<String,Boolean> response = new HashMap<>();
        response.put("exists",exists);
        return ResponseEntity.ok(response);
    }

    //enter new tool to the database
    @PostMapping("/create")
    public ResponseEntity<Tool> newTool(@RequestBody Tool newTool) {
        try {
            Tool savedTool = toolRepo.save(newTool);
            System.out.println("New Tool Successfully Added!");
            return ResponseEntity.ok(savedTool);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Inside updateTool method
    @PutMapping("/update/{toolId}")
    public ResponseEntity<Tool> updateTool(@RequestBody Tool newTool, @PathVariable("toolId") String toolId){

        try {
            Optional<Tool> existingToolOptional = toolRepo.findById(toolId);
            if (existingToolOptional.isPresent()) {
                Tool existingTool = existingToolOptional.get();
                existingTool.setToolName(newTool.getToolName());
                existingTool.setDescription(newTool.getDescription());
                existingTool.setQuantity(newTool.getQuantity());
                Tool updatedTool = toolRepo.save(existingTool);
                return ResponseEntity.ok(updatedTool);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //delete tool details from the inventory
    @DeleteMapping("/delete/{toolId}")
    public ResponseEntity<String> deleteTool(@PathVariable ("toolId") String toolId)
    {
        try{
            Optional<Tool> toolOptional = toolRepo.findById(toolId);
            if(toolOptional.isPresent()){
                toolRepo.deleteById(toolId);
                return ResponseEntity.ok("Tool deleted successfully");
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting tool: "+e.getMessage());
        }
    }


}













