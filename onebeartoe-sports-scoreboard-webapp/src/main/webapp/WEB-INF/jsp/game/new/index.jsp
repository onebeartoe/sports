
<div class="copyspace">
    <h3>Current Game</h3>
    <div class="featuredProject">
        <p>		
        <form method="POST" action="${pageContext.request.contextPath}/game/new">                    
            
            <br/>
            <input type="hidden" name="newSchedlue" value="${newSchedlue}"> 
            <pre>                    
                ${newGame}
            </pre>              

            Periods:
            <select name="periods" >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>            

            </b>
            
            <br/>
            <pre>                    
                
            </pre>              

            <input type="submit" value="New Game">
        </form>
        </p>
    </div>
    <br class="clearingBreak">
</div>

